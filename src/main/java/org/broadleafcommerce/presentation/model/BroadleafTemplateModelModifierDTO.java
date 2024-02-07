/*-
 * #%L
 * BroadleafCommerce Common Presentation
 * %%
 * Copyright (C) 2009 - 2024 Broadleaf Commerce
 * %%
 * Licensed under the Broadleaf Fair Use License Agreement, Version 1.0
 * (the "Fair Use License" located  at http://license.broadleafcommerce.org/fair_use_license-1.0.txt)
 * unless the restrictions on use therein are violated and require payment to Broadleaf in which case
 * the Broadleaf End User License Agreement (EULA), Version 1.1
 * (the "Commercial License" located at http://license.broadleafcommerce.org/commercial_license-1.1.txt)
 * shall apply.
 * 
 * Alternatively, the Commercial License may be replaced with a mutually agreed upon license (the "Custom License")
 * between you and Broadleaf Commerce. You may not use this file except in compliance with the applicable license.
 * #L%
 */
package org.broadleafcommerce.presentation.model;

import org.broadleafcommerce.presentation.dialect.AbstractBroadleafModelModifierProcessor;

import java.util.HashMap;
import java.util.Map;

/**
 * Holder object for passing around a {@link BroadleafTemplateModel} and a Map that represents the parameters
 * that should be used when creating the tag. See {@link AbstractBroadleafModelModifierProcessor}
 * 
 * @author Jay Aisenbrey (cja769)
 */
public class BroadleafTemplateModelModifierDTO {

    protected BroadleafTemplateModel model;
    protected Map<String, String> formParameters = new HashMap<>();
    protected Map<String, Object> formLocalVariables = new HashMap<>();
    protected String replacementTagName;
    
    public BroadleafTemplateModelModifierDTO() {
        // default constructor intentionally left empty
    }

    public BroadleafTemplateModelModifierDTO(BroadleafTemplateModel model, Map<String, String> formParameters, String replacementTagName) {
        this.model = model;
        this.formParameters = formParameters;
        this.replacementTagName = replacementTagName;
    }
    
    public BroadleafTemplateModelModifierDTO(BroadleafTemplateModel model, Map<String, String> formParameters, Map<String, Object> formLocalVariables, String replacementTagName) {
        this.model = model;
        this.formParameters = formParameters;
        this.formLocalVariables = formLocalVariables;
        this.replacementTagName = replacementTagName;
    }

    public BroadleafTemplateModel getModel() {
        return model;
    }

    public void setModel(BroadleafTemplateModel model) {
        this.model = model;
    }

    public Map<String, String> getFormParameters() {
        return formParameters;
    }

    public void setFormParameters(Map<String, String> formParameters) {
        this.formParameters = formParameters;
    }

    public Map<String, Object> getFormLocalVariables() {
        return formLocalVariables;
    }

    public void setFormLocalVariables(Map<String, Object> formLocalVariables) {
        this.formLocalVariables = formLocalVariables;
    }
    
    public String getReplacementTagName() {
        return replacementTagName;
    }
    
    public void setReplacementTagName(String replacementTagName) {
        this.replacementTagName = replacementTagName;
    }
}
