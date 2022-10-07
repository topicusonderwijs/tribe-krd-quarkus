/*
 * Copyright 2022 Topicus Onderwijs Eduarte B.V..
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package nl.topicus.eduarte.model.entities.security.authentication;

import javax.persistence.Basic;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import nl.topicus.eduarte.model.entities.personen.ExterneOrganisatieContactPersoon;

/**
 * Account voor deelnemers.
 *
 */
@Entity()
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = "Instelling")
@DiscriminatorValue(value = "ExtOrgContPersAccount")
public class ExterneOrganisatieContactPersoonAccount extends Account {
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "externeOrganisatieContPers", nullable = true)
	@Basic(optional = false)
	private ExterneOrganisatieContactPersoon externeOrganisatieContactPersoon;

	public ExterneOrganisatieContactPersoon getExterneOrganisatieContactPersoon() {
		return externeOrganisatieContactPersoon;
	}

	public void setExterneOrganisatieContactPersoon(ExterneOrganisatieContactPersoon externeOrganisatieContactPersoon) {
		this.externeOrganisatieContactPersoon = externeOrganisatieContactPersoon;
	}
}
