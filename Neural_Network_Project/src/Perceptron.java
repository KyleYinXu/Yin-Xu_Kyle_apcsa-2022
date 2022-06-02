import java.util.Arrays;

public class Perceptron {
	private int threshold;
	private int[] weights;
	private int learning_rate;
	private int bias;
	public Perceptron(int ninputs, int threshold, int learning_rate) {
		this.threshold = threshold;
		this.learning_rate = learning_rate;
		this.bias = 0;
		this.weights = new int[ninputs];
	}
	public int predict(int[] inputs) {
		int z = bias;
		for(int i = 0; i < inputs.length; i++) {
			z+= inputs[i] * weights[i];
		}
		if(z > 0)
			return 1;
		return 0;
	}
	public void train(int[][] training_inputs,int[] labels) {
		for(int i = 0; i < threshold; i++) {
			for(int j = 0; j < training_inputs.length; j++) {
				int yhat = predict(training_inputs[j]);
				int error = labels[j] - yhat;
				for(int k = 0; k < training_inputs[j].length; k++) {
					weights[k] += learning_rate * error * training_inputs[j][k];
				}
				bias+= learning_rate * error;
			}
		}
	}
	public static void main(String[] args) {
		//(1, 0, 0, 0} AND {1, 1, 1, 0} OR {0, 1, 1, 1} NAND
		int[] labels = {0, 1, 1, 0};
		int[][] input_matrix = {{1, 1}, {1, 0}, {0, 1}, {0, 0}};
		Perceptron perceptron = new Perceptron(2, 10, 1);
		perceptron.train(input_matrix, labels);
		int a = 1;
		int b = 0;
		int[] inputs = {a, b};
		int output = perceptron.predict(inputs);
		System.out.println("Input: " + Arrays.toString(inputs) + "\nOutput: " + output);
	}
}
