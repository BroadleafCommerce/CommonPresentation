/*-
 * #%L
 * BroadleafCommerce Common Presentation
 * %%
 * Copyright (C) 2009 - 2023 Broadleaf Commerce
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

/**
 * Interface for all {@link BroadleafThymeleafElement}s that have the ability to add elements inside of it. An example is something like a
 * {@code <p>some text</p>} tag as opposed to a {@code <br />} tag that has no body.
 * 
 * @author Jay Aisenbrey (cja769)
 * @see {@link BroadleafTemplateContext} for how to create these elements
 */
public interface BroadleafTemplateNonVoidElement extends BroadleafTemplateElement {

    /**
     * Adds a child element to this element. Adding elements conserves order in which they were added 
     */
    public void addChild(BroadleafTemplateElement child);
}
