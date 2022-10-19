import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

class Games{
    private int app_id, age, dlc, avg_pt, avg_pt1, avg_pt2;
    private String name, owners, website, developers, releaseDate;
    private float price, upvotes;
    private String[] lenguages, genres = new String[100];
    private boolean windows, mac, linux;

    Games(){
        this.app_id = 0;
        this.name = null;
        this.releaseDate = null;
        this.owners = null;
        this.age = 0;
        this.price = 0;
        this.dlc = 0;
        this.lenguages = new String[100];
        this.website = null; 
        this.windows = false;
        this.mac = false;
        this.linux = false;
        this.upvotes = 0;
        this.avg_pt = 0;
        this.avg_pt1 = 0;
        this.avg_pt2 = 0;
        this.developers = null;
        this.genres = new String[100];
    }
    
    public void setApp_id(int num){
        this.app_id = num;
    }
    
    public int getApp_id(){
        return app_id;
    }

    public void setName(String str){
		this.name = str;
	}
	
	public String getName(){
		return name;
	}

    public void setReleaseDate(String date){
		this.releaseDate = date;
	}
	
	public String getReleaseDate(){
		return releaseDate;
	}

    public void setOwners(String str){
        this.owners = str;
    }

    public String getOwners(){
        return owners;
    }

    public void setAge(int num){
        this.age = num;
    }

    public int getAge(){
        return age;
    }

    public void setPrice(float numf){
        this.price = numf;
    }

    public float getPrice(){
        return price;
    }

    public void setDlc(int num){
        this.dlc = num;
    }

    public int getDlc(){
        return dlc;
    }

    public void setLenguages(String[] arr){ 
        this.lenguages = arr;
    }

    public String[] getLenguage(){ 
        return lenguages;
    }

    public void setWebsite(String str){
        this.website = str;
    }

    public String getWebsite(){
        return website;
    }

    public void setWindows(Boolean bool){
        this.windows = bool;
    }

    public Boolean getWindows(){
        return windows;
    }

    public void setMac(Boolean bool){
        this.mac = bool;
    }

    public Boolean getMac(){
        return mac;
    }

    public void setLinux(Boolean bool){
        this.linux = bool;
    }

    public Boolean getLinux(){
        return linux;
    }

    public void setUpVotes(float numf){
        this.upvotes = numf;
    }

    public float getUpVotes(){
        return upvotes;
    }

    public void setAvg_pt(int num){
        this.avg_pt = num;
    }
    
    public int getAvg_pt(){
        return avg_pt;
    }

    public void setAvg_pt1(int num){
        this.avg_pt1 = num;
    }
    
    public int getAvg_pt1(){
        return avg_pt1;
    }

    public void setAvg_pt2(int num){
        this.avg_pt2 = num;
    }
    
    public int getAvg_pt2(){
        return avg_pt2;
    }

    public void setDevelopers(String str){
        this.developers = str;
    }

    public String getDevelopers(){
        return developers;
    }

    public void setGenres(String[] arr){ 
        this.genres = arr;
    }

    public String[] getGenres(){ 
        return genres;
    }

    public static int[] parseAvg_Pt(String s){
        int valor = Integer.parseInt(s.trim());
        int minutos = valor % 60;
        int horas = (valor - minutos) / 60;
        int resp[] = new int[2];
        resp[0] = horas;
        resp[1] = minutos;
        return resp;
        }

    public static float upVotes(String s1, String s2){
        float up = Float.parseFloat(s1);
        float down = Float.parseFloat(s2);
        float resp;
        resp = ((up + down) / 100);
        resp = up / resp;
        return resp;
    }

    public static String[] stringToArray(String s){
        String[] resp = new String[100];
        resp = s.split(",");
        for(int i = 0; i < resp.length; i++){
            resp[i] = resp[i].replaceAll("'", "");
            resp[i] = resp[i].replaceAll("]", "");
            resp[i] = resp[i].trim();
        }
        return resp;
    }

    public static String stringToDate(String s) throws ParseException {
        if (s.length() > 8) {
            String format = "MMM/yyyy";
            Date d = new SimpleDateFormat("MMM dd, yyyy", Locale.ENGLISH).parse(s.trim());
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            return sdf.format(d);
        } else {
            s.replace(" ", "/");
            return s;
        }
        /*String d;
        String[] data = s.split(" ");
		return (d = data[0] + "/" + data[2]);*/
	}

    public static boolean IsLenguage( String linha, int i){
        if (linha.charAt(i) == ']' && linha.charAt(i+1) == '\"' && linha.charAt(i+2) == ','){
            return true;
        }else if (linha.charAt(i) == ']' && linha.charAt(i+1) == ','){
            return true;
        } else{
            return false;
        }
    }

    public static String parseLenguage(String s){
        
        return s;
    }

    public Games ler(String entrada) throws IOException, ParseException{
        Games resp = new Games();
        String linha, aux = "";
        int cont = 0;
        String[] arr = new String[100];
        FileReader isr = new FileReader("../tmp/games.csv");
        BufferedReader br = new BufferedReader(isr);

        while((linha = br.readLine()) != null){
            arr = linha.split(",", -1);
            if(entrada.compareTo(arr[0]) == 0){
                for(int i = 0; i < linha.length(); i++){
                    while(linha.charAt(i) != ','){ // App_id
                        aux += linha.charAt(i);
                        i++;
                    }
                    //System.out.println(aux);
                    resp.setApp_id(Integer.parseInt(aux));
                    //System.err.println(aux);
                    aux = "";
                    i++;
                    if (linha.charAt(i) == '\"') {
                        i++;
                        while(linha.charAt(i) != '\"'){ // Name
                            aux += linha.charAt(i);
                            i++;    
                        }
                        i++;
                    } else {
                        while(linha.charAt(i) != ','){ // Name
                            aux += linha.charAt(i);
                            i++;    
                        }
                    }
                    //System.out.println("1: " + aux);
                    resp.setName(aux);
                    i += 1;
                    aux = "";
                    if (linha.charAt(i) == '\"') {
                        i++;
                        while(linha.charAt(i) != '\"'){ // Release_date
                            aux += linha.charAt(i);
                            aux = aux.replaceAll("\"", "");
                            i++;
                        }
                    } else {
                        i++;
                        while(linha.charAt(i) != ',') {
                            aux += linha.charAt(i);
                            i++;
                        }
                        i++;
                    }
                    
                    //System.out.println("2: " +aux);
                    resp.setReleaseDate(stringToDate(aux));
                    i+=2;
                    aux = "";
                    while(linha.charAt(i) != ','){ // Owners
                        aux += linha.charAt(i);
                        i++;
                    }
                    //System.out.println("3: " +aux);
                    resp.setOwners(aux);
                    i++;
                    aux = "";
                    while(linha.charAt(i) != ','){ // Age
                        aux += linha.charAt(i);
                        i++;
                    }
                    //System.out.println("4: " + aux);
                    resp.setAge(Integer.parseInt(aux));
                    i++;
                    aux = "";
                    while(linha.charAt(i) != ','){ // Price
                        aux += linha.charAt(i);
                        i++;
                    }
                    //System.out.println("5: " + aux);
                    resp.setPrice(Float.parseFloat(aux));
                    i++;
                    aux = "";
                    while(linha.charAt(i) != ','){ // Dlcs
                        aux += linha.charAt(i);
                        i++;
                    }
                    //System.out.println("6: " + aux);
                    resp.setDlc(Integer.parseInt(aux));
                    i ++;
                    aux = "";
                    while(IsLenguage(linha, i) == false){ // Lenguages
                        if(linha.charAt(i) != '[')
                            aux += linha.charAt(i);
                        i++;
                    }
                    aux = aux.replaceAll("\"", "");
                    aux = aux.replaceAll("[b]", "");
                    aux = aux.replaceAll("[/b]", "");
                    aux = aux.replaceAll("/n", "");
                    aux = aux.replaceAll("/r", "");
                    aux = aux.replaceAll("]", "");
                    //System.out.println("Lenguages: " + String.join(", ", stringToArray(aux)));
                    resp.setLenguages(stringToArray(aux));
                    i ++;
                    aux = "";
                    cont = 0;
                    while(linha.charAt(i) != ','){
                        i++;
                    }
                    if (linha.charAt(i + 1) != '\"') {
                        i++;
                        while(linha.charAt(i) != ','){ // Website
                            aux += linha.charAt(i);
                            i++;
                        }
                        i++;
                    } else {
                        i+= 2;
                        while(linha.charAt(i) != '\"'){ // Website
                            aux += linha.charAt(i);
                            i++;
                        }
                        i++;
                    }
                    if (linha.charAt(i) == ',') i++;
                    //System.out.println("8: " +aux);
                    resp.setWebsite(aux);
                    i++;
                    aux = "";
                    while(linha.charAt(i) != ','){ // Windows
                        aux += linha.charAt(i);
                        i++;
                    }
                    //System.out.println("9: " + aux);
                    resp.setWindows(Boolean.parseBoolean(aux));
                    i++;
                    aux = "";
                    while(linha.charAt(i) != ','){ // Mac
                        aux += linha.charAt(i);
                        i++;
                    }
                    //System.out.println("10: " + aux);
                    resp.setMac(Boolean.parseBoolean(aux));
                    i++;
                    aux = "";
                    while(linha.charAt(i) != ','){ // Linux
                        aux += linha.charAt(i);
                        i++;
                    }
                    //System.out.println(aux);
                    resp.setLinux(Boolean.parseBoolean(aux));
                    i++;
                    aux = "";
                    while(linha.charAt(i) != ','){ // UpVotes
                        aux += linha.charAt(i);
                        i++;
                    }
                    i++;
                    String aux1 = "";
                    while(linha.charAt(i) != ','){ // DownVotes
                        aux1 += linha.charAt(i);
                        i++;
                    } 
                    //System.out.println(aux + " -- " + aux1);
                    resp.setUpVotes((int)Math.round(upVotes(aux, aux1)));
                    i++;
                    aux = "";
                    while(linha.charAt(i) != ','){ // Avg_pt
                        aux += linha.charAt(i);
                        i++;
                    }
                    resp.setAvg_pt(Integer.parseInt(aux));
                    int[] aux2 = parseAvg_Pt(aux);
                    //System.out.println(aux2[0]);
                    resp.setAvg_pt1(aux2[0]);
                    //System.out.println(aux2[1]);
                    resp.setAvg_pt2(aux2[1]);
                    i ++;
                    aux = "";
                    while(linha.charAt(i) != ','){ // Dev
                        aux += linha.charAt(i);
                        aux = aux.replaceAll("\"", "");
                        i++;
                    }
                    //System.out.println(aux);
                    resp.setDevelopers(aux);
                    i ++;
                    aux = "";
                    while(i != linha.length()){ // Genres
                        aux += linha.charAt(i);
                        aux = aux.replaceAll("\"", "");
                        i++;
                    }
                    if(aux != ""){
                        //System.out.println(aux);
                        resp.setGenres(stringToArray(aux));
                    }
                    i = linha.length();
                }
            }
        }
        return resp;
    }

}

class TP03Q06{
    static int comp = 0;
    static int mov = 0;

    public static void swap(Games[] array, int i, int j) {
        Games temp = array[i];
        array[i] = array[j];
        array[j] = temp;
     }

    public static void quicksort(Games[] array, int esq, int dir) {
          int i = esq, j = dir;
          Games pivo = array[(dir+esq)/2];
          while (i <= j) {
              while (array[i].getReleaseDate().compareTo(pivo.getReleaseDate()) < 0) i++;
              while (array[j].getReleaseDate().compareTo(pivo.getReleaseDate()) > 0) j--;
              if (i <= j) {
                  swap(array, i, j);
                  i++;
                  j--;
              }
          }
          if (esq < j)  quicksort(array, esq, j);
          if (i < dir)  quicksort(array, i, dir);
      }

    public static boolean isFim(String s){
        return (s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1)== 'I' && s.charAt(2) == 'M');
    }

    public static void log(int comp , long tempo, int mov){
        Arq.openWrite("729051_HeapSort.txt");

        Arq.print("729051"+'\t'+tempo+'\t'+comp+'\t'+mov);

        Arq.close();
    }

    public static void printGames (Games[] game, int numEntradas){

        for(int i = 0; i < numEntradas; i++){
            System.out.print(game[i].getApp_id() + " " + game[i]. getName().trim() + " " + game[i].getReleaseDate().trim() + " " + game[i].getOwners().trim() + " " + game[i].getAge() + " " + game[i].getPrice() + " " + game[i].getDlc() + " [" + String.join(", ", game[i].getLenguage()).trim() + "] " + game[i].getWebsite().trim() + " " + game[i].getWindows() + " " + game[i].getMac() + " " + game[i].getLinux() + " " + (int)game[i].getUpVotes() + "% " + game[i].getAvg_pt1() + "h " + game[i].getAvg_pt2() + "m " + game[i].getDevelopers().trim() + " [");
                if(game[i].getGenres()[0] != null){
                    System.out.print(String.join(", ", game[i].getGenres()).trim());
                }else{
                    String[] arr = new String[1];
                    arr[0] = null;
                    System.out.print(arr[0]);
                }
                System.out.println("] ");
        }
    }
  

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        Games[] game = new Games[100];
        String[] entrada = new String[100];
        int numEntradas = 0;

        do{
            entrada[numEntradas] = scn.nextLine();
        }while(isFim(entrada[numEntradas++]) == false );
        numEntradas--;

        for(int i = 0; i < numEntradas; i++){
            game[i] = new Games();
            game[i] = game[i].ler(entrada[i]);
        }

        long tempoinicio = System.currentTimeMillis();

        quicksort(game, 0, numEntradas-1);

        long tempo = System.currentTimeMillis() - tempoinicio;

        printGames(game, numEntradas);

        log(comp , tempo, mov);

    }
}