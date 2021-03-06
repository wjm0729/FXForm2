/*
 * Copyright (c) 2013, dooApp <contact@dooapp.com>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification, are permitted provided that the following conditions are met:
 *
 * Redistributions of source code must retain the above copyright notice, this list of conditions and the following disclaimer.
 * Redistributions in binary form must reproduce the above copyright notice, this list of conditions and the following disclaimer in the documentation and/or other materials provided with the distribution.
 * Neither the name of dooApp nor the names of its contributors may be used to endorse or promote products derived from this software without specific prior written permission.
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package com.dooapp.fxform.filter;

import com.dooapp.fxform.model.Element;

import java.util.List;

/**
 * User: Antoine Mischler <antoine@dooapp.com>
 * Date: 12/09/11
 * Time: 15:15
 */
public abstract class AbstractNameFilter implements ElementListFilter {

	protected final String[] names;

	public AbstractNameFilter(String[] names) {
		this.names = names;
	}

	protected Element extractFieldByName(List<Element> remaining, String name) throws FilterException {
		Element element = getFieldByName(remaining, name);
		remaining.remove(element);
		return element;
	}

	protected Element getFieldByName(List<Element> elements, String name) throws FilterException {
		for (Element field : elements) {
			String fullName = field.getDeclaringClass().getName() + "-" + field.getName();
			if (field.sourceProperty().getValue() != null) {
				fullName = field.sourceProperty().getValue().getClass().getName() + "-" + field.getName();
			}
			if (name.equals(fullName) || name.equals(field.getName())) {
				return field;
			}
		}
		throw new FilterException(name + " not found in field list, please check your filters");
	}

	public String[] getNames() {
		return names;
	}
}
