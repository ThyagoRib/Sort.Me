package sort.me;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import sort.me.algorithms.*;
import sort.me.arrays.graphicalArrays.*;
import sort.me.arrays.virtualArrays.*;

public class ControlPanel extends JPanel implements ActionListener {
	
	private GridBagConstraints gbc = new GridBagConstraints();
	private JComboBox algorithmBox;
	private JComboBox testCaseBox;
	private JTextField arraySizeField;
	
	protected static ControlPanel panelInstance;
	
	private ControlPanel() {
		setLayout(new GridBagLayout());
		gbc.insets = new Insets(5, 5, 5, 5);
		//gbc.anchor = GridBagConstraints.CENTER;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		//gbc.weighty = 0;
		
		initializeLabels();
		initializeBoxes();
		initializeTextField();
		initializeButton();
	}
	
	public static ControlPanel getPanelInstance() {
		if (panelInstance == null)
			panelInstance = new ControlPanel();
		
		return panelInstance;
	}

	private void initializeLabels() {
		JLabel label;
		
		//gbc.weightx = 0;
		
		label = new JLabel("Algorithms:");
		gbc.gridx = 0;
		gbc.gridy = 0;
		add(label, gbc);
		
		label = new JLabel("Test Case:");
		gbc.gridx = 0;
		gbc.gridy = 1;
		add(label, gbc);
		
		label = new JLabel("Array Size:");
		gbc.gridx = 0;
		gbc.gridy = 2;
		add(label, gbc);
		
	}
	
	private void initializeBoxes() {
			
		gbc.weightx = 1;
		
		String[] algorithmsList = {"Bubble Sort", "Quick Sort (last element pivot)", "Cocktail Sort", "Heap Sort",
				"Insertion Sort", "Selection Sort", "Shell Sort", "Comb Sort"};
		algorithmBox = new JComboBox(algorithmsList);
		gbc.gridx = 1;
		gbc.gridy = 0;
		add(algorithmBox, gbc);
		
		String[] testCasesList = {"Random Array", "Reversed Array", "Almost Sorted", "Few Unique"};
		testCaseBox = new JComboBox(testCasesList);
		gbc.gridx = 1;
		gbc.gridy = 1;
		add(testCaseBox, gbc);
	}
	
	private void initializeTextField() {
		arraySizeField = new JTextField("50");
		
		gbc.gridx = 1;
		gbc.gridy = 2;
		
		add(arraySizeField, gbc);
	}
	
	private void initializeButton() {
		JButton button = new JButton("Run");
		button.addActionListener(this);
		
		gbc.fill = GridBagConstraints.NONE;
		gbc.anchor = GridBagConstraints.NORTH;
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.gridwidth = 2;
		gbc.weighty = 1;
		
		add(button, gbc);
	}
	
	private VirtualArray getSelectedTestCase() {
		String arrayType = (String) testCaseBox.getSelectedItem();
		VirtualArray array; 
		
		switch (arrayType) {
		case "Random Array":
			array = new RandomArray();
			break;
		case "Reversed Array":
			array = new ReversedArray();
			break;
		case "Almost Sorted":
			array = new AlmostSortedArray();
			break;
		case "Few Unique":
			array = new FewUniqueArray();
			break;
		default:
			array = null;
		}
		
		return array;
		
	}
	
	private SortingAlgorithm getSelectedAlgorithm() {
		String selectedAlgorithm = (String) algorithmBox.getSelectedItem();
		SortingAlgorithm algorithm;
		
		switch (selectedAlgorithm) {
		case "Bubble Sort":
			algorithm = new BubbleSort();
			break;
		case "Quick Sort (last element pivot)":
			algorithm = new QuickSort();
			break;
		case "Cocktail Sort":
			algorithm = new CocktailSort();
			break;
		case "Heap Sort":
			algorithm = new HeapSort();
			break;
		case "Insertion Sort":
			algorithm = new InsertionSort();
			break;
		case "Selection Sort":
			algorithm = new SelectionSort();
			break;
		case "Shell Sort":
			algorithm = new ShellSort();
			break;
		case "Comb Sort":
			algorithm = new CombSort();
			break;
		default:
			algorithm = null;
		}
		
		return algorithm;
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		
		
		try {
			int size = Integer.parseInt(arraySizeField.getText());
				if(size > 60 || size < 5)
					JOptionPane.showMessageDialog(null, "For better results enter a value between 5 and 60!");
			
			VirtualArray virtualArray = getSelectedTestCase();
			virtualArray.generate(size);
			VisualArray visualArray = new VisualArray(virtualArray);
			
			SortingAlgorithm algorithm = getSelectedAlgorithm();
			
			new AnimationThread(visualArray, algorithm).start();
		}
		catch (NumberFormatException e) {}
	}
	
}