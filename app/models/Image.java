/*
 * Copyright (c) 2014-2015 University of Ulm
 *
 * See the NOTICE file distributed with this work for additional information
 * regarding copyright ownership.  Licensed under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package models;

import models.generic.Model;

import javax.persistence.*;
import java.util.List;

@Entity public class Image extends Model {

    @Column(updatable = false) private String cloudUuid;

    @ManyToOne(optional = false) private ImageProperties imageProperties;

    @ManyToOne(optional = false) private Cloud cloud;

    @ManyToMany private List<CloudCredential> cloudCredentials;

    @OneToMany(mappedBy = "image", cascade = CascadeType.REMOVE)
    private List<VirtualMachineTemplate> virtualMachineTemplates;

    /**
     * Empty constructor for hibernate.
     */
    private Image() {
    }

    public Image(String cloudUuid, Cloud cloud, ImageProperties imageProperties) {
        this.cloudUuid = cloudUuid;
        this.cloud = cloud;
        this.imageProperties = imageProperties;
    }

    public String getCloudUuid() {
        return cloudUuid;
    }

    public Cloud getCloud() {
        return cloud;
    }

    public ImageProperties getImageProperties() {
        return imageProperties;
    }
}
