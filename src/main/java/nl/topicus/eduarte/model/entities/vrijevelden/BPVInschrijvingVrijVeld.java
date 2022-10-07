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
package nl.topicus.eduarte.model.entities.vrijevelden;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import nl.topicus.eduarte.model.entities.VrijVeldable;
import nl.topicus.eduarte.model.entities.bpv.BPVInschrijving;

@Entity()
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = "Instelling")
public class BPVInschrijvingVrijVeld extends VrijVeldEntiteit
{
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "bpvInschrijving", nullable = true)
	private BPVInschrijving bpvInschrijving;

	public BPVInschrijvingVrijVeld()
	{
	}

	public BPVInschrijving getBpvInschrijving()
	{
		return bpvInschrijving;
	}

	public void setBpvInschrijving(BPVInschrijving bpvInschrijving)
	{
		this.bpvInschrijving = bpvInschrijving;
	}

	@Override
	public VrijVeldable< ? extends VrijVeldEntiteit> getEntiteit()
	{
		return getBpvInschrijving();
	}

	@Override
	public void setEntiteit(VrijVeldable< ? extends VrijVeldEntiteit> entiteit)
	{
		setBpvInschrijving((BPVInschrijving) entiteit);
	}
}
