import java.io.*;
import java.util.Random;
import java.util.StringJoiner;

public class Mozart {

    private int NewCompositionMeasure;
    private BufferedWriter FileWriter;
    private int[] measureArray;
    private int[][] measures;

    public Mozart () throws IOException {
        Random rand = new Random();
        measures =  new int[][] {
                {96, 32, 69, 40, 148, 104, 152, 119, 98, 3, 54},
                {22, 6, 95, 17, 74, 157, 60, 84, 142, 87, 130},
                {141, 128, 158, 113, 163, 27, 171, 114, 42, 165, 10},
                {41, 63, 13, 85, 45, 167, 53, 50, 156, 61, 103},
                {105, 146, 153, 161, 80, 154, 99, 140, 75, 135, 28},
                {122, 46, 55, 2, 97, 68, 133, 86, 129, 47, 37},
                {11, 134, 110, 159, 36, 118, 21, 169, 62, 147, 106},
                {30, 81, 24, 100, 107, 91, 127, 94, 123, 33, 5},
                {70, 117, 66, 90, 25, 138, 16, 120, 65, 102, 35},
                {121, 39, 136, 176, 143, 71, 155, 88, 77, 4, 20},
                {26, 126, 15, 7, 64, 150, 57, 48, 19, 31, 108},
                {9, 56, 132, 34, 125, 29, 175, 166, 82, 164, 92},
                {112, 174, 73, 67, 76, 101, 43, 51, 137, 144, 12},
                {49, 18, 58, 160, 136, 162, 168, 115, 38, 59, 124},
                {109, 116, 145, 52, 1, 23, 89, 72, 149, 173, 44},
                {14, 83, 79, 170, 93, 151, 172, 111, 8, 78, 131}
        };

        NewCompositionMeasure = 1;
        File OutputComposition = new File("output.txt");
        FileOutputStream fos = new FileOutputStream(OutputComposition);
        FileWriter = new BufferedWriter(new OutputStreamWriter(fos));
        measureArray = new int[16];
        for (int i = 0; i < 16; i++) {
            measureArray[i] = measures[i][rand.nextInt(11)];
            System.out.println("Chose measure: " + measureArray[i]);
        }
    }
    public Boolean IsInMeasure(String line, int measure) {
        String[] noteData = line.split(" ");
        if (((((int) Double.parseDouble(noteData[1])) / 3) + 1) == measure) {
            System.out.println("int data: " + Double.parseDouble(noteData[1]));
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    public Boolean ReadCompositionFile(String fileName, Integer measure) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader(fileName));
        String line;
        while ((line = in.readLine()) != null) {

            if (IsInMeasure(line, measure)){
                // System.out.println(line);
                String newLine = ConvertLineToNewCompositionMeasure(line, measure);
                // System.out.println(newLine);
                AppendNewLine(newLine);
            }

        }
        // only leave this in if you're testing ReadComposition
        // FileWriter.close();
        return Boolean.FALSE;
    }

    private void AppendNewLine(String inputLine) throws IOException {
        FileWriter.write(inputLine);
        FileWriter.newLine();
    }

    private String ConvertLineToNewCompositionMeasure(String line, int measure) {
        int converter = (NewCompositionMeasure - measure) * 3;
        String[] noteData = line.split(" ");
        Double newBeat = Double.parseDouble(noteData[1]) + converter;
        if (newBeat == Math.floor(newBeat))
        {
            noteData[1] = Integer.toString(newBeat.intValue());
        }
        else
        {
            noteData[1] = Double.toString(newBeat);
        }
        // System.out.println("original: " + noteData[1] + " new: " + newBeat);
        String newBeatLine = String.join(" ", noteData);
        return newBeatLine;
    }

    public Boolean CreateComposition() throws Exception {
        for (int i = 0; i < 16; i++) {
            ReadCompositionFile(".\\src\\original_composition.txt", measureArray[i]);
            NewCompositionMeasure++;
        }
        FileWriter.close();
        return Boolean.FALSE;
    }
}
