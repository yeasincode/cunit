package cn.weltown.cunit;

import java.net.URL;

import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.application.IWorkbenchConfigurer;
import org.eclipse.ui.application.IWorkbenchWindowConfigurer;
import org.eclipse.ui.application.WorkbenchAdvisor;
import org.eclipse.ui.application.WorkbenchWindowAdvisor;
import org.eclipse.ui.ide.IDE;
import org.eclipse.ui.internal.ide.IDEWorkbenchPlugin;
import org.osgi.framework.Bundle;

public class ApplicationWorkbenchAdvisor extends WorkbenchAdvisor {

	@Override
	public void initialize(IWorkbenchConfigurer configurer) {
		super.initialize(configurer);
		
		IDE.registerAdapters();
		 
	    final String ICONS_PATH = "icons/full/";
//	    final String PATH_OBJECT = ICONS_PATH + "obj16/";
	    
	    final String IDE_OBJECT="platform:/plugin/org.eclipse.ui.ide"+ICONS_PATH+ "obj16/";
	    
	    Bundle ideBundle = Platform.getBundle(IDEWorkbenchPlugin.IDE_WORKBENCH);
	    declareWorkbenchImage(configurer, ideBundle,
	        IDE.SharedImages.IMG_OBJ_PROJECT, IDE_OBJECT + "prj_obj.png", true);
	    declareWorkbenchImage(configurer, ideBundle,
	        IDE.SharedImages.IMG_OBJ_PROJECT_CLOSED, IDE_OBJECT + "cprj_obj.png", true);
	}
	
	private void declareWorkbenchImage(IWorkbenchConfigurer configurer_p,
        Bundle ideBundle, String symbolicName, String path, boolean shared) {
	    URL url = ideBundle.getEntry(path);
	    ImageDescriptor desc = ImageDescriptor.createFromURL(url);
	    configurer_p.declareImage(symbolicName, desc, shared);
	}

	@Override
	public WorkbenchWindowAdvisor createWorkbenchWindowAdvisor(IWorkbenchWindowConfigurer configurer) {
		return new ApplicationWorkbenchWindowAdvisor(configurer);
	}

	@Override
	public String getInitialWindowPerspectiveId() {
		return Perspective.ID;
	}
}
