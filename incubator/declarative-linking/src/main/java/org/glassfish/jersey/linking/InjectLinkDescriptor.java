/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright (c) 2010-2015 Oracle and/or its affiliates. All rights reserved.
 *
 * The contents of this file are subject to the terms of either the GNU
 * General Public License Version 2 only ("GPL") or the Common Development
 * and Distribution License("CDDL") (collectively, the "License").  You
 * may not use this file except in compliance with the License.  You can
 * obtain a copy of the License at
 * http://glassfish.java.net/public/CDDL+GPL_1_1.html
 * or packager/legal/LICENSE.txt.  See the License for the specific
 * language governing permissions and limitations under the License.
 *
 * When distributing the software, include this License Header Notice in each
 * file and include the License file at packager/legal/LICENSE.txt.
 *
 * GPL Classpath Exception:
 * Oracle designates this particular file as subject to the "Classpath"
 * exception as provided by Oracle in the GPL Version 2 section of the License
 * file that accompanied this code.
 *
 * Modifications:
 * If applicable, add the following below the License Header, with the fields
 * enclosed by brackets [] replaced by your own identifying information:
 * "Portions Copyright [year] [name of copyright owner]"
 *
 * Contributor(s):
 * If you wish your version of this file to be governed by only the CDDL or
 * only the GPL Version 2, indicate your decision by adding "[Contributor]
 * elects to include this software in this distribution under the [CDDL or GPL
 * Version 2] license."  If you don't indicate a single choice of license, a
 * recipient has the option to distribute your version of this file under
 * either the CDDL, the GPL Version 2 or to extend the choice of license to
 * its licensees as provided above.  However, if you add GPL Version 2 code
 * and therefore, elected the GPL Version 2 license, then the option applies
 * only if the new code is made subject to such option by the copyright
 * holder.
 */

package org.glassfish.jersey.linking;

import org.glassfish.jersey.linking.InjectLink.LinkQueryParam;
import org.glassfish.jersey.linking.mapping.ResourceMappingContext;

import javax.ws.rs.core.MultivaluedMap;

import java.util.Set;

/**
 * Utility for working with @Ref annotations
 *
 * @author Mark Hadley
 * @author Gerard Davison (gerard.davison at oracle.com)
 */
interface InjectLinkDescriptor {

    /**
     * Get the style
     * @return the style
     */
    InjectLink.Style getLinkStyle();

    /**
     * Get the link template, either directly from the value() or from the
     * @Path of the class referenced in resource()
     * @return the link template
     */
    String getLinkTemplate(ResourceMappingContext rmc);

    /**
     * Get the binding as an EL expression for a particular URI template parameter
     * @param name
     * @return the EL binding
     */
    String getBinding(String name);

    /**
     * Get the condition.
     * @return the condition
     */
    String getCondition();

    /**
     * Get the list of query parameters injected by @LinkQueryParam.
     * @return the list of query parameters.
     */
    MultivaluedMap<String, String> getQueryParams();

    /**
     * The request query parameters should be included in response Links.
     * @return true if we need request query parameters.
     */
    boolean copyFromRequestParams();

    /**
     * A list of request parameters keys to exclude from response links.
     * It's used if copyFromRequestParams() is enabled.
     *
     * @return the list of parameters keys names to exclude.
     */
    Set<String> excludeFromRequestParams();

}
