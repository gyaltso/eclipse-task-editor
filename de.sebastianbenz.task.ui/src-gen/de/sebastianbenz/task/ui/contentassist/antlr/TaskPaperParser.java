/*
* generated by Xtext
*/
package de.sebastianbenz.task.ui.contentassist.antlr;

import java.util.Collection;
import java.util.Map;
import java.util.HashMap;

import org.antlr.runtime.RecognitionException;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.ui.editor.contentassist.antlr.AbstractContentAssistParser;
import org.eclipse.xtext.ui.editor.contentassist.antlr.FollowElement;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;

import com.google.inject.Inject;

import de.sebastianbenz.task.services.TaskPaperGrammarAccess;

public class TaskPaperParser extends AbstractContentAssistParser {
	
	@Inject
	private TaskPaperGrammarAccess grammarAccess;
	
	private Map<AbstractElement, String> nameMappings;
	
	@Override
	protected de.sebastianbenz.task.ui.contentassist.antlr.internal.InternalTaskPaperParser createParser() {
		de.sebastianbenz.task.ui.contentassist.antlr.internal.InternalTaskPaperParser result = new de.sebastianbenz.task.ui.contentassist.antlr.internal.InternalTaskPaperParser(null);
		result.setGrammarAccess(grammarAccess);
		return result;
	}
	
	@Override
	protected String getRuleName(AbstractElement element) {
		if (nameMappings == null) {
			nameMappings = new HashMap<AbstractElement, String>() {
				private static final long serialVersionUID = 1L;
				{
					put(grammarAccess.getTodoAccess().getAlternatives_1(), "rule__Todo__Alternatives_1");
					put(grammarAccess.getContentAccess().getAlternatives(), "rule__Content__Alternatives");
					put(grammarAccess.getTodoAccess().getGroup(), "rule__Todo__Group__0");
					put(grammarAccess.getTaskAccess().getGroup(), "rule__Task__Group__0");
					put(grammarAccess.getNoteAccess().getGroup(), "rule__Note__Group__0");
					put(grammarAccess.getProjectAccess().getGroup(), "rule__Project__Group__0");
					put(grammarAccess.getSpacesAccess().getGroup(), "rule__Spaces__Group__0");
					put(grammarAccess.getTodoAccess().getContentsAssignment_1_0(), "rule__Todo__ContentsAssignment_1_0");
					put(grammarAccess.getTaskAccess().getIntendAssignment_0(), "rule__Task__IntendAssignment_0");
					put(grammarAccess.getTaskAccess().getTextAssignment_1(), "rule__Task__TextAssignment_1");
					put(grammarAccess.getNoteAccess().getIntendAssignment_0(), "rule__Note__IntendAssignment_0");
					put(grammarAccess.getNoteAccess().getTextAssignment_1(), "rule__Note__TextAssignment_1");
					put(grammarAccess.getProjectAccess().getIntendAssignment_0(), "rule__Project__IntendAssignment_0");
					put(grammarAccess.getProjectAccess().getTextAssignment_1(), "rule__Project__TextAssignment_1");
				}
			};
		}
		return nameMappings.get(element);
	}
	
	@Override
	protected Collection<FollowElement> getFollowElements(AbstractInternalContentAssistParser parser) {
		try {
			de.sebastianbenz.task.ui.contentassist.antlr.internal.InternalTaskPaperParser typedParser = (de.sebastianbenz.task.ui.contentassist.antlr.internal.InternalTaskPaperParser) parser;
			typedParser.entryRuleTodo();
			return typedParser.getFollowElements();
		} catch(RecognitionException ex) {
			throw new RuntimeException(ex);
		}		
	}
	
	@Override
	protected String[] getInitialHiddenTokens() {
		return new String[] {  };
	}
	
	public TaskPaperGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}
	
	public void setGrammarAccess(TaskPaperGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
}
