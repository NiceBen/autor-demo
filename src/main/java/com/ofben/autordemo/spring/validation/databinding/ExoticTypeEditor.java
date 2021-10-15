package com.ofben.autordemo.spring.validation.databinding;

import java.beans.PropertyEditor;
import java.beans.PropertyEditorSupport;

/**
 * {@link PropertyEditor}
 *
 * @date 2021-10-15
 * @since 1.0.0
 */
public class ExoticTypeEditor extends PropertyEditorSupport {

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        setValue(new ExoticType(text.toUpperCase()));
    }
}
