package cn.weltown.cunit.handler;

import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Shell;

import cn.weltown.cunit.wizard.MyWizard;
public class NewProjectHandler {

	@Execute
	public void execute(Shell shell){
		WizardDialog dialog = new WizardDialog(shell, new MyWizard());
		dialog.open();
	}
}
