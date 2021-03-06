/*******************************************************************************
 * Portions created by Sebastian Thomschke are copyright (c) 2005-2011 Sebastian
 * Thomschke.
 * 
 * All Rights Reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Sebastian Thomschke - initial implementation.
 *******************************************************************************/
package net.sf.oval.configuration.annotation;

import java.lang.annotation.Annotation;

import net.sf.oval.Check;
import net.sf.oval.exception.InvalidConfigurationException;

/**
 * Interface for constraint checks that are configurable via annotations.
 * 
 * @author Sebastian Thomschke
 */
public interface AnnotationCheck<ConstraintAnnotation extends Annotation> extends Check
{
	/**
	 * Configures the check based on the given constraint annotation.
	 * @param constraintAnnotation the constraint annotation to use for configuration
	 * @throws net.sf.oval.exception.InvalidConfigurationException in case of an illegal configuration setting
	 */
	void configure(ConstraintAnnotation constraintAnnotation) throws InvalidConfigurationException;
}
