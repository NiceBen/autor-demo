package com.ofben.autordemo.spring.validation.typeconversion;

import com.ofben.autordemo.spring.validation.databinding.ExoticType;
import com.ofben.autordemo.spring.validation.databinding.ExoticTypeEditor;
import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.PropertyEditorRegistry;

/**
 * {@link PropertyEditorRegistrar}
 *
 * @date 2021-10-15
 * @since 1.0.0
 */
public class CustomPropertyEditorRegistrar implements PropertyEditorRegistrar {

    @Override
    public void registerCustomEditors(PropertyEditorRegistry registry) {
        registry.registerCustomEditor(ExoticType.class, new ExoticTypeEditor());
    }
}
