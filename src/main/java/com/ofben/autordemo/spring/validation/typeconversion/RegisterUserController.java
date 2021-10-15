package com.ofben.autordemo.spring.validation.typeconversion;

import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.web.bind.ServletRequestDataBinder;

import javax.servlet.http.HttpServletRequest;

/**
 * {@link PropertyEditorRegistrar}
 *
 * @date 2021-10-15
 * @since 1.0.0
 */
public final class RegisterUserController extends SimpleFormController {

    private final PropertyEditorRegistrar registrar;

    public RegisterUserController(PropertyEditorRegistrar registrar) {
        this.registrar = registrar;
    }

    protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) throws Exception {
        this.registrar.registerCustomEditors(binder);
    }
}
