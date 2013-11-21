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

package com.dooapp.fxform.model.impl;

import com.dooapp.fxform.model.PropertyElement;
import javafx.beans.property.Property;
import javafx.beans.value.ObservableValue;

import java.lang.reflect.Method;

/**
 * User: Antoine Mischler <antoine@dooapp.com>
 * Date: 16/10/13
 * Time: 15:06
 */
public class PropertyMethodElement<SourceType, WrappedType> extends ReadOnlyPropertyMethodElement<SourceType, WrappedType> implements PropertyElement<WrappedType> {

    public PropertyMethodElement(Method method) {
        super(method);
    }

    @Override
    public void setValue(WrappedType wrappedType) {
        getProperty().setValue(wrappedType);
    }

    public void bind(ObservableValue<? extends WrappedType> observableValue) {
        getProperty().bind(observableValue);
    }

    public void unbind() {
        getProperty().unbind();
    }

    public boolean isBound() {
        return getProperty().isBound();
    }

    public void bindBidirectional(Property<WrappedType> wrappedTypeProperty) {
        getProperty().bindBidirectional(wrappedTypeProperty);
    }

    public void unbindBidirectional(Property<WrappedType> wrappedTypeProperty) {
        getProperty().unbindBidirectional(wrappedTypeProperty);
    }

    protected Property<WrappedType> getProperty() {
        return (Property<WrappedType>) super.wrappedProperty().getValue();
    }

}