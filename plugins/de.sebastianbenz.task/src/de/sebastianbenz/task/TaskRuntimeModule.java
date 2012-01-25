/*******************************************************************************
 * Copyright (c) 2011 Sebastian Benz.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Sebastian Benz - initial API and implementation
 ******************************************************************************/
/*
 * generated by Xtext
 */
package de.sebastianbenz.task;

import org.eclipse.xtext.conversion.IValueConverterService;
import org.eclipse.xtext.linking.ILinker;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.resource.IDefaultResourceDescriptionStrategy;
import org.eclipse.xtext.resource.ILocationInFileProvider;
import org.eclipse.xtext.validation.CompositeEValidator;

import com.google.inject.Binder;

import de.sebastianbenz.task.model.RestructuringLinker;
import de.sebastianbenz.task.resource.LocationInFileProvider;
import de.sebastianbenz.task.resource.TaskResourceDescriptionStrategy;
import de.sebastianbenz.task.services.TaskValueConverterService;
import de.sebastianbenz.task.util.TaskQualifiedNameProvider;

/**
 * Use this class to register components to be used at runtime / without the
 * Equinox extension registry.
 */
public class TaskRuntimeModule extends
		de.sebastianbenz.task.AbstractTaskRuntimeModule {

	@Override
	public void configure(Binder binder) {
		super.configure(binder);
		binder.bind(IDefaultResourceDescriptionStrategy.class).to(
				TaskResourceDescriptionStrategy.class);
	}

	public Class<? extends ILocationInFileProvider> bindILocationInFileProvider() {
		return LocationInFileProvider.class;
	}

	@Override
	public Class<? extends IQualifiedNameProvider> bindIQualifiedNameProvider() {
		return TaskQualifiedNameProvider.class;
	}

	public void configureEObjectValidator(com.google.inject.Binder binder) {
		binder.bindConstant().annotatedWith( //
				com.google.inject.name.Names.named(//
						CompositeEValidator.USE_EOBJECT_VALIDATOR)).to(false);
	}
	
	@Override
	public Class<? extends ILinker> bindILinker() {
		return RestructuringLinker.class;
	}
	
	@Override
	public Class<? extends IValueConverterService> bindIValueConverterService() {
		return TaskValueConverterService.class;
	}

}
