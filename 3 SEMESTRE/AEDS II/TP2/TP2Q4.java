import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

class Games{
    private int app_id, age, dlc, avg_pt1, avg_pt2;
    private String name, owners, website, developers, releaseDate;
    private float price, upvotes;
    private String[] lenguages, genres = new String[100];
    private boolean windows, mac, linux;

    Games(){
        this.app_id = 0;
        this.name = "";
        this.releaseDate = "";
        this.owners = "";
        this.age = 0;
        this.price = 0;
        this.dlc = 0;
        this.lenguages = new String[100];
        this.website = ""; 
        this.windows = false;
        this.mac = false;
        this.linux = false;
        this.upvotes = 0;
        this.avg_pt1 = 0;
        this.avg_pt2 = 0;
        this.developers = "";
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
        FileReader isr = new FileReader("/tmp/games.csv");
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

class TP2Q4{

    public static boolean pesquisaBinaria(Games[] game, String nome, int n){
        int meio;   
        int inicio = 0;   
        int fim = n - 1;   
        while (inicio <= fim) {   
             meio = (inicio + fim)/2;   
             if (nome.compareTo(game[meio].getName().trim()) == 0)   
                      return true;   
             if (nome.compareTo(game[meio].getName().trim()) < 0)   
                      fim = meio - 1;   
             else   
                      inicio = meio + 1;   
        }   
        return false;   

    }

    public static boolean isFim(String s){
        return (s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1)== 'I' && s.charAt(2) == 'M');
    }

    /*public static void log(int comp , long tempo){
        Arq.openWrite("729051_sequencial.txt");

        Arq.print("729051"+'\t'+tempo+'\t'+comp);

        Arq.close();
    }*/

    public static void main(String[] args) throws IOException, ParseException {
        Scanner scn = new Scanner(System.in);
        Games[] game = new Games[4404];
        String[] entrada = new String[4404];
        String[] nomes = new String[1000];
        int numEntradas = 0;
        int numNomes = 0;
        int comparacoes = 0;

        do{
            entrada[numEntradas] = scn.nextLine();
        }while(isFim(entrada[numEntradas++]) == false );
        numEntradas--;

        for(int i = 0 ;  i< numEntradas ; i++){
            game[i] = new Games();
            game[i] = game[i].ler(entrada[i]);
        }

        do{
            nomes[numNomes] = scn.nextLine();
        }while(isFim(nomes[numNomes++]) == false );
        numNomes--;

        //long tempoinicio = System.currentTimeMillis();
        int aux;

        for(int i = 0; i < numNomes; i++){
            aux = 0;
            if(pesquisaBinaria(game , nomes[i], numEntradas) == true){
                System.out.println("SIM");
            }else{
                System.out.println("NAO");
            }
            /*for(int j = 0; j < numEntradas; j++){
                if(nomes[i].compareTo(game[j].getName()) == 0){
                    comparacoes++;
                    aux = 1;
                    j+=numEntradas;
                }*/
        }

        //long tempo = System.currentTimeMillis() - tempoinicio;

        //log(comparacoes , tempo);

    }
}