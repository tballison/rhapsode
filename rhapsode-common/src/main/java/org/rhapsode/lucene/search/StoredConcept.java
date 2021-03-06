/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * NOTICE

 * This software was produced for the U.S. Government
 * under Basic Contract No. W15P7T-13-C-A802,
 * W15P7T-12-C-F600, and W15P7T-13-C-F600, and is
 * subject to the Rights in Noncommercial Computer Software
 * and Noncommercial Computer Software Documentation
 * Clause 252.227-7014 (FEB 2012)
 *
 * (C) 2013-2017 The MITRE Corporation. All Rights Reserved.
 *
 */

package org.rhapsode.lucene.search;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class StoredConcept {

    final String conceptName;
    String conceptQuery;
    String conceptTranslation;
    String notes;
    String conceptExcMsg;

    StoredConcept(String name) {
        this.conceptName = name;
    }

    public static List<String> getDBColNames() {
        List<String> cols = new ArrayList<>();
        for (SCField field : SCField.values()) {
            cols.add(field.getDbName());
        }
        return cols;
    }

    public String getConceptName() {
        return conceptName;
    }

    public String getConceptQuery() {
        return conceptQuery;
    }

    public String getConceptTranslation() {
        return conceptTranslation;
    }

    public String getNotes() {
        return notes;
    }

    public String getConceptExcMsg() {
        return conceptExcMsg;
    }

    public String getString(SCField scField) {
        try {
            Field field = this.getClass().getDeclaredField(scField.getObjFieldName());
            return (String) field.get(this);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return "StoredConcept{" +
                "conceptName='" + conceptName + '\'' +
                ", conceptQuery='" + conceptQuery + '\'' +
                ", conceptTranslation='" + conceptTranslation + '\'' +
                ", notes='" + notes + '\'' +
                ", conceptExcMsg='" + conceptExcMsg + '\'' +
                '}';
    }
}
