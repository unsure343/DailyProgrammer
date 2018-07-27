import java.io.*;
import java.util.Random;

class Mozart {

    private int NewCompositionCurrentMeasure;
    private int[] NewCompositionMeasureArray;
    private BufferedWriter FileWriter;

    Mozart() {
        int[][] OriginalCompositionMeasures =  new int[][] {
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
        NewCompositionCurrentMeasure = 1;
        NewCompositionMeasureArray = new int[16];
        Random rand = new Random();
        for (int i = 0; i < 16; i++) {
            NewCompositionMeasureArray[i] =
                    OriginalCompositionMeasures[i][rand.nextInt(6) + rand.nextInt(6)];
            // System.out.println("Chose measure: " + NewCompositionMeasureArray[i]);
        }
    }

    void CreateComposition() throws Exception {
        File OutputComposition = new File("output.txt");
        FileOutputStream fos = new FileOutputStream(OutputComposition);
        FileWriter = new BufferedWriter(new OutputStreamWriter(fos));
        for (int i = 0; i < 16; i++) {
            GetNextMeasure(".\\src\\original_composition.txt",
                    NewCompositionMeasureArray[i]);
            NewCompositionCurrentMeasure++;
        }
        FileWriter.close();
    }

    private void GetNextMeasure(String fileName, int measure) throws IOException {
        BufferedReader inputFile = new BufferedReader(new FileReader(fileName));
        String line;
        while ((line = inputFile.readLine()) != null) {
            if (IsInMeasure(line, measure)){
                // System.out.println(line);
                String nextLine = ConvertLineBeatToNewCompositionBeat(line, measure);
                // System.out.println(nextLine);
                AppendNextLineToNewComposition(nextLine);
            }
        }
    }

    private Boolean IsInMeasure(String line, int measure) {
        String[] noteData = line.split(" ");
        if (((((int) Double.parseDouble(noteData[1])) / 3) + 1) == measure) {
            // System.out.println("int data: " + Double.parseDouble(noteData[1]));
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    private void AppendNextLineToNewComposition(String inputLine) throws IOException {
        FileWriter.write(inputLine);
        FileWriter.newLine();
    }

    private String ConvertLineBeatToNewCompositionBeat(String line, int measure) {
        int conversion = (NewCompositionCurrentMeasure - measure) * 3;
        String[] noteData = line.split(" ");
        Double newBeat = Double.parseDouble(noteData[1]) + conversion;
        if (newBeat == Math.floor(newBeat))
        {
            noteData[1] = Integer.toString(newBeat.intValue());
        }
        else
        {
            noteData[1] = Double.toString(newBeat);
        }
        // System.out.println("original: " + noteData[1] + " new: " + newBeat);
        return String.join(" ", noteData);
    }
}
