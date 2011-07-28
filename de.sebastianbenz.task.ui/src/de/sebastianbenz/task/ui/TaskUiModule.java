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
package de.sebastianbenz.task.ui;

import java.util.Collection;
import java.util.Collections;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.XtextSourceViewerConfiguration;
import org.eclipse.xtext.ui.editor.autoedit.AbstractEditStrategyProvider;
import org.eclipse.xtext.ui.editor.contentassist.ITemplateProposalProvider;
import org.eclipse.xtext.ui.editor.folding.FoldedPosition;
import org.eclipse.xtext.ui.editor.folding.IFoldingRegionProvider;
import org.eclipse.xtext.ui.editor.model.IResourceForEditorInputFactory;
import org.eclipse.xtext.ui.editor.model.ITokenTypeToPartitionTypeMapper;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.editor.model.ResourceForIEditorInputFactory;
import org.eclipse.xtext.ui.editor.syntaxcoloring.AbstractAntlrTokenToAttributeIdMapper;
import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightingConfiguration;
import org.eclipse.xtext.ui.resource.IResourceSetProvider;
import org.eclipse.xtext.ui.resource.SimpleResourceSetProvider;

import com.google.inject.Binder;

import de.sebastianbenz.task.ui.contentassist.TaskTemplateProvider;
import de.sebastianbenz.task.ui.editor.AutoEditStrategyProvider;
import de.sebastianbenz.task.ui.editor.SourceViewerConfiguration;
import de.sebastianbenz.task.ui.editor.TaskEditor;
import de.sebastianbenz.task.ui.editor.TaskTokenTypeToPartitionTypeMapper;
import de.sebastianbenz.task.ui.highlighting.HighlightingConfiguration;
import de.sebastianbenz.task.ui.highlighting.SemanticHighlightingCalculator;
import de.sebastianbenz.task.ui.highlighting.TokenHighlightingConfiguration;

/**
 * Use this class to register components to be used within the IDE.
 */
public class TaskUiModule extends de.sebastianbenz.task.ui.AbstractTaskUiModule {
	public static class NoFolding implements IFoldingRegionProvider {

		public Collection<FoldedPosition> getFoldingRegions(
				IXtextDocument xtextDocument) {
			return Collections.emptyList();
		}

	}

	public TaskUiModule(AbstractUIPlugin plugin) {
		super(plugin);
	}

	@Override
	public void configure(Binder binder) {
		super.configure(binder);
		binder.bind(XtextEditor.class).to(TaskEditor.class);
	}

	public Class<? extends IFoldingRegionProvider> bindIFoldingRegionProvider(){
		return NoFolding.class;
	}
	
	public Class<? extends org.eclipse.xtext.ui.editor.syntaxcoloring.ISemanticHighlightingCalculator> bindISemanticHighlightingCalculator() {
		return SemanticHighlightingCalculator.class;
	}

	public Class<? extends IHighlightingConfiguration> bindIHighlightingConfiguration() {
		return HighlightingConfiguration.class;
	}

	public Class<? extends AbstractAntlrTokenToAttributeIdMapper> bindAbstractAntlrTokenToAttributeIdMapper() {
		return TokenHighlightingConfiguration.class;
	}

	@Override
	public Class<? extends AbstractEditStrategyProvider> bindAbstractEditStrategyProvider() {
		return AutoEditStrategyProvider.class;
	}

	public Class<? extends XtextSourceViewerConfiguration> bindXtextSourceViewerConfiguration() {
		return SourceViewerConfiguration.class;
	}

	@Override
	public Class<? extends ITemplateProposalProvider> bindITemplateProposalProvider() {
		return TaskTemplateProvider.class;
	}

	@Override
	public Class<? extends IResourceForEditorInputFactory> bindIResourceForEditorInputFactory() {
		return ResourceForIEditorInputFactory.class;
	}

	@Override
	public Class<? extends IResourceSetProvider> bindIResourceSetProvider() {
		return SimpleResourceSetProvider.class;
	}

	@Override
	public com.google.inject.Provider<org.eclipse.xtext.resource.containers.IAllContainersState> provideIAllContainersState() {
		return org.eclipse.xtext.ui.shared.Access.getWorkspaceProjectsState();
	}
	
	@org.eclipse.xtext.service.SingletonBinding(eager=true)	public Class<? extends de.sebastianbenz.task.validation.TaskJavaValidator> bindTaskJavaValidator() {
		return de.sebastianbenz.task.ui.validation.TaskUiValidator.class;
	}
	
	public Class<? extends ITokenTypeToPartitionTypeMapper> bindITokenTypeToPartitionTypeMapper(){
		return TaskTokenTypeToPartitionTypeMapper.class;
	}
	
}
