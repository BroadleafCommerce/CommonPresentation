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
package org.broadleafcommerce.presentation.resolver;

import java.io.InputStream;

/**
 * Class used to indicate a new Template Resolver to be used to resolve file names
 *
 * @author Jay Aisenbrey (cja769)
 */
public interface BroadleafTemplateResolver {

    /**
     * @return The string that should be automatically added to the beginning of given
     * template name (i.e. for servlet template resolvers {@code /WEB-INF/})
     */
    String getPrefix();

    /**
     * @return The string that should be automatically added to the end of given
     * template name (i.e. {@code .html})
     */
    String getSuffix();

    /**
     * @return The string that should be added after the prefix but before the given
     * template name to designate set of templates (i.e. {@code templates/})
     * <p>
     * note string should end in a {@code /}
     */
    String getTemplateFolder();

    /**
     * @return A boolean indicating if the templates resolved through the template resolver
     * should be cached
     */
    Boolean isCacheable();

    /**
     * @return The amount of time (in minutes) for a template to live in cache
     */
    Long getCacheTTLMs();

    /**
     * @return The character encoding of the templates that this resolver returns
     * (i.e. Usually {@code UTF-8})
     */
    String getCharacterEncoding();

    /**
     * @return The order in the list of all {@code BroadleafThymeleafTemplateResolver} that this resolver should run
     */
    Integer getOrder();

    /**
     * @return The type of templates this resolver resolves for
     */
    BroadleafTemplateMode getTemplateMode();

    /**
     * @return The type of resolver this resolver is
     */
    BroadleafTemplateResolverType getResolverType();

    /**
     * @return true if this resolver should be in the set of email resolvers
     */
    Boolean isEmailResolver();

    /**
     * Custom logic for resolving the given resource.
     *
     * @param template
     * @param resourceName
     * @return The requested resource as an input stream.
     */
    InputStream resolveResource(String template, String resourceName);
}

