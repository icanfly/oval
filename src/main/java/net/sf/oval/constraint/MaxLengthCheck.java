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
package net.sf.oval.constraint;

import static net.sf.oval.Validator.getCollectionFactory;

import java.util.Map;

import net.sf.oval.ConstraintTarget;
import net.sf.oval.Validator;
import net.sf.oval.configuration.annotation.AbstractAnnotationCheck;
import net.sf.oval.context.OValContext;

/**
 * @author Sebastian Thomschke
 */
public class MaxLengthCheck extends AbstractAnnotationCheck<MaxLength>
{
	private static final long serialVersionUID = 1L;

	private int max;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void configure(final MaxLength constraintAnnotation)
	{
		super.configure(constraintAnnotation);
		setMax(constraintAnnotation.value());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Map<String, String> createMessageVariables()
	{
		final Map<String, String> messageVariables = getCollectionFactory().createMap(2);
		messageVariables.put("max", Integer.toString(max));
		return messageVariables;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected ConstraintTarget[] getAppliesToDefault()
	{
		return new ConstraintTarget[]{ConstraintTarget.VALUES};
	}

	/**
	 * @return the max
	 */
	public int getMax()
	{
		return max;
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean isSatisfied(final Object validatedObject, final Object valueToValidate, final OValContext context,
			final Validator validator)
	{
		if (valueToValidate == null) return true;

		final int len = valueToValidate.toString().length();
		return len <= max;
	}

	/**
	 * @param max the max to set
	 */
	public void setMax(final int max)
	{
		this.max = max;
		requireMessageVariablesRecreation();
	}
}
