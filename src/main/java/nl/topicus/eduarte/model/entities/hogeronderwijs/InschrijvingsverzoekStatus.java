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
package nl.topicus.eduarte.model.entities.hogeronderwijs;

public enum InschrijvingsverzoekStatus implements KeyValue
{
	AanmeldVervolg("B", "Aanmelding vervolg"),
	Inschrijving("I"),
	GeannlIngetrk("G", "Geannuleerd/ingetrokken"),
	Uitgeschreven("U"),
	StudieStaken("S", "Studie staken"),
	Afgewezen("R"),
	VerzoekInschr("V", "Verzoek tot inschrijving");

	private String key;

	private String value;

	@Override
	public String getKey()
	{
		return key;
	}

	@Override
	public String getValue()
	{
		return value;
	}

	private InschrijvingsverzoekStatus(String key)
	{
		this.key = key;
		this.value = name();
	}

	private InschrijvingsverzoekStatus(String key, String value)
	{
		this.key = key;
		this.value = value;
	}

	@Override
	public String toString()
	{
		return value;
	}
}
