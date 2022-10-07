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
package nl.topicus.eduarte.model.entities.bpv;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import nl.topicus.eduarte.model.entities.bpv.BPVCriteria.BPVCriteriaStatus;
import nl.topicus.eduarte.model.entities.organisatie.InstellingEntiteit;


@Entity
public class BPVCriteriaBPVKandidaat extends InstellingEntiteit
{

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "bpvKandidaat", nullable = false)
	private BPVKandidaat bpvKandidaat;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "bpvCriteria", nullable = false)
	private BPVCriteria bpvCriteria;

	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private BPVCriteriaStatus status;

	public BPVCriteriaBPVKandidaat()
	{
	}

	public BPVCriteriaBPVKandidaat(BPVKandidaat bpvKandidaat)
	{
		setBpvKandidaat(bpvKandidaat);
	}

	public BPVCriteriaBPVKandidaat(BPVKandidaat bpvKandidaat, BPVCriteria bpvCriteria,
			BPVCriteriaStatus status)
	{
		setBpvKandidaat(bpvKandidaat);
		setBpvCriteria(bpvCriteria);
		setStatus(status);
	}

	public void setBpvKandidaat(BPVKandidaat bpvKandidaat)
	{
		this.bpvKandidaat = bpvKandidaat;
	}

	public BPVKandidaat getBpvKandidaat()
	{
		return bpvKandidaat;
	}

	public void setStatus(BPVCriteriaStatus status)
	{
		this.status = status;
	}

	public BPVCriteriaStatus getStatus()
	{
		return status;
	}

	public void setBpvCriteria(BPVCriteria bpvCriteria)
	{
		this.bpvCriteria = bpvCriteria;
	}

	public BPVCriteria getBpvCriteria()
	{
		return bpvCriteria;
	}

	@Override
	public BPVCriteriaBPVKandidaat clone()
	{
		return new BPVCriteriaBPVKandidaat(getBpvKandidaat(), getBpvCriteria(), getStatus());
	}
}