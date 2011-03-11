/*
 * generated by Xtext
 */
package de.sebastianbenz.task.ui;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.XtextSourceViewerConfiguration;
import org.eclipse.xtext.ui.editor.autoedit.AbstractEditStrategyProvider;
import org.eclipse.xtext.ui.editor.folding.IFoldingRegionProvider;
import org.eclipse.xtext.ui.editor.syntaxcoloring.AbstractAntlrTokenToAttributeIdMapper;
import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightingConfiguration;

import com.google.inject.Binder;

import de.sebastianbenz.task.ui.editor.AutoEditStrategyProvider;
import de.sebastianbenz.task.ui.editor.FoldingRegionProvider;
import de.sebastianbenz.task.ui.editor.TaskPaperSourceViewerConfiguration;
import de.sebastianbenz.task.ui.highlighting.HighlightingConfiguration;
import de.sebastianbenz.task.ui.highlighting.SemanticHighlightingCalculator;
import de.sebastianbenz.task.ui.highlighting.TokenHighlightingConfiguration;

/**
 * Use this class to register components to be used within the IDE.
 */
public class TaskPaperUiModule extends de.sebastianbenz.task.ui.AbstractTaskPaperUiModule {
	public TaskPaperUiModule(AbstractUIPlugin plugin) {
		super(plugin);
	}
	
	@Override
	public void configure(Binder binder) {
		super.configure(binder);
		binder.bind(XtextEditor.class).to(TaskEditor.class);
		binder.bind(IFoldingRegionProvider.class).to(FoldingRegionProvider.class);
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
	
	public Class<? extends XtextSourceViewerConfiguration> bindXtextSourceViewerConfiguration(){
		return TaskPaperSourceViewerConfiguration.class;
	}
	
	
}
