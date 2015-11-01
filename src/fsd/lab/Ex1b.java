package fsd.lab;

import static fsd.lab.ArrayUtils.*;

import mpi.MPI;
import mpi.Request;

public class Ex1b {

	public static void main(String[] args) {
		double[] dataSent = new double[FAIR_SIZE];
		double[] dataRecieved = new double[FAIR_SIZE];

		MPI.Init(args);

		int rank = MPI.COMM_WORLD.Rank();
		int tag = 333;
		if (rank != 0) {
			initArray(FAIR_SIZE, dataSent);
			System.out.println("Send data\n");
			doubleValuesOfArray(dataSent);
			Request iSendRequest = MPI.COMM_WORLD.Isend(dataSent, 0, FAIR_SIZE, MPI.DOUBLE, 0, tag);
			iSendRequest.Wait();
		} else {
			System.out.println("Recieve data\n");
			Request iRecvRequest = MPI.COMM_WORLD.Irecv(dataRecieved, 0, FAIR_SIZE, MPI.DOUBLE, 1, tag);
			iRecvRequest.Wait();
			System.out.println("Data recieved: ");
			printArray(dataRecieved);
		}
		MPI.Finalize();
	}

}
