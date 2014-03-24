package seu.Client.util;

import java.awt.Component;
import java.awt.Container;
import java.awt.GridBagConstraints;

public class GBLAdd {
	public static void addComp(Component c, Container container,
			GridBagConstraints gbConstraints, int x, int y, int width,
			int height, double weightx, double weighty) {

		// Set parameters
		gbConstraints.gridx = x;
		gbConstraints.gridy = y;
		gbConstraints.gridwidth = width;
		gbConstraints.gridheight = height;
		gbConstraints.weightx = weightx;
		gbConstraints.weighty = weighty;

		// Add component to the container with the specified layout
		container.add(c, gbConstraints);
	}

}
