package utility;

import pojos.Room;
import pojos.Room1;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class TXTWriter {


    public static void main(String[]args){


        String filePathName = "src/test/test_data/Batch8889.txt";

        Room room = new Room("Development",100, 28938, "TWIN", true );


        generateRoomData(room, filePathName);


    }


    public static void generateRoomData(Room room, String path){


        try{


            FileWriter fileWriter = new FileWriter(path,false);
            //src/test/test_data
            //Batch8889.txt
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            //This is just to write into the file given

            bufferedWriter.append(room+"\n");

            bufferedWriter.close();






        }catch (Exception e) {
            e.printStackTrace();
        }



    }



    public static void generateRoomData(Room1[] rooms, String path){


        try{


            FileWriter fileWriter = new FileWriter(path,false);
            //src/test/test_data
            //Batch8889.txt
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            //This is just to write into the file given

            for (int i = 0; i < rooms.length; i++) {
                bufferedWriter.append(rooms[i].getDescription()+": "+rooms[i].getId()+"\n");
            }


            bufferedWriter.close();






        }catch (Exception e) {
            e.printStackTrace();
        }



    }





}
