package fsd.lab;

import mpi.MPI;
import static fsd.lab.ArrayUtils.*;

public class Ex1a {
	public static void main(String... args) {
		double[] dataSent = new double[FAIR_SIZE];
		double[] dataRecieved = new double[FAIR_SIZE];

		MPI.Init(args);

		int rank = MPI.COMM_WORLD.Rank();
		int size = MPI.COMM_WORLD.Size();
		int dest = 0;
		int tag = 333;
		if (rank != 0) {
			initArray(FAIR_SIZE, dataSent);
			System.out.println("Send data\n");
			doubleValuesOfArray(dataSent);
			MPI.COMM_WORLD.Send(dataSent, 0, FAIR_SIZE, MPI.DOUBLE, dest, tag);
		} else {
			System.out.println("Recieve data\n");
			MPI.COMM_WORLD.Recv(dataRecieved, 0, FAIR_SIZE, MPI.DOUBLE, 1, tag);
			System.out.println("Data recieved: ");
			printArray(dataRecieved);
		}
		System.out.println("I am process <" + rank + "> of total <" + size + "> processes.");
		MPI.Finalize();
	}
}
