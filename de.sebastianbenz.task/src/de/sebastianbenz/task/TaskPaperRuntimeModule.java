/*
 * generated by Xtext
 */
package de.sebastianbenz.task;

import org.eclipse.xtext.resource.ILocationInFileProvider;

import de.sebastianbenz.task.resource.LocationInFileProvider;

/**
 * Use this class to register components to be used at runtime / without the Equinox extension registry.
 */
public class TaskPaperRuntimeModule extends de.sebastianbenz.task.AbstractTaskPaperRuntimeModule {

	public Class<? extends ILocationInFileProvider> bindILocationInFileProvider() {
		return LocationInFileProvider.class;
	}
	
}
