package singleton;

import iterator.SłownikIterator;

import java.util.*;

public final class Słownik{
    private static Słownik instance = new Słownik();
    private List<Słowo> listaSłów;

    private Słownik() {
        listaSłów = new ArrayList<Słowo>();
        dodajDaneDoSłownika();

    }

    public static Słownik getInstance() {
        return instance;
    }

    public Iterator<Słowo> iterator(List<SłowoKategoria> kategorie){

        if(kategorie.isEmpty()){
            Iterator<Słowo> it = listaSłów.iterator();
            return it;
        }
        else{
            return new SłownikIterator(this, kategorie);
        }
    }

    public void usunSlowo(Słowo słowo){
        listaSłów.remove(słowo);
    }

    public Słowo znajdzSlowo(String słowoPl){
        for(Słowo słowo : listaSłów){
            if(słowo.getPoPolsku().equals(słowoPl)){
                return słowo;
            }
        }
        return null;
    }

    public boolean edytujSlowo(Słowo doZmiany, Słowo nowe){
        for(Słowo słowo : listaSłów){
            if(słowo.getPoPolsku().equals(doZmiany.getPoPolsku())){
                słowo.setPoPolsku(nowe.getPoPolsku());
                słowo.setPoAngielsku(nowe.getPoAngielsku());
                słowo.setSłowoKategoria(nowe.getSłowoKategoria());
                słowo.setTrudnośćSłowa(nowe.getTrudnośćSłowa());
                return true;
            }
        }
        return false;
    }

    public boolean dodajSlowo(Słowo słowo){

        if(listaSłów.add(słowo)) return true;
        return false;
    }

    public List<Słowo> getAll() {
        return new ArrayList<>(listaSłów);
    }


    private void dodajDaneDoSłownika(){
        listaSłów.add(new Słowo("kot","cat", SłowoKategoria.Zwierzęta, Trudność.BradzoŁatwy));
        listaSłów.add(new Słowo("pies","dog", SłowoKategoria.Zwierzęta, Trudność.BradzoŁatwy));
        listaSłów.add(new Słowo("ptak","bird", SłowoKategoria.Zwierzęta, Trudność.BradzoŁatwy));
        listaSłów.add(new Słowo("żaba","frog", SłowoKategoria.Zwierzęta, Trudność.BradzoŁatwy));
        listaSłów.add(new Słowo("skrzek","frogspawn", SłowoKategoria.Zwierzęta, Trudność.BradzoŁatwy));
        listaSłów.add(new Słowo("traszka","newt", SłowoKategoria.Zwierzęta, Trudność.BradzoŁatwy));
        listaSłów.add(new Słowo("kijanka","tadpole", SłowoKategoria.Zwierzęta, Trudność.BradzoŁatwy));
        listaSłów.add(new Słowo("ropucha","toad", SłowoKategoria.Zwierzęta, Trudność.BradzoŁatwy));
        listaSłów.add(new Słowo("skorpion","scorpion", SłowoKategoria.Zwierzęta, Trudność.BradzoŁatwy));
        listaSłów.add(new Słowo("pająk","spider", SłowoKategoria.Zwierzęta, Trudność.BradzoŁatwy));
        listaSłów.add(new Słowo("tarantula","tarantula", SłowoKategoria.Zwierzęta, Trudność.BradzoŁatwy));
        listaSłów.add(new Słowo("albatros","albatross", SłowoKategoria.Zwierzęta, Trudność.BradzoŁatwy));

        listaSłów.add(new Słowo("zięba","finch", SłowoKategoria.Zwierzęta, Trudność.Łatwy));
        listaSłów.add(new Słowo("kos","blackbird", SłowoKategoria.Zwierzęta, Trudność.Łatwy));
        listaSłów.add(new Słowo("kanarek","canary", SłowoKategoria.Zwierzęta, Trudność.Łatwy));
        listaSłów.add(new Słowo("wrona","crow", SłowoKategoria.Zwierzęta, Trudność.Łatwy));
        listaSłów.add(new Słowo("kukułka","cuckoo", SłowoKategoria.Zwierzęta, Trudność.Łatwy));
        listaSłów.add(new Słowo("gołąb","dove", SłowoKategoria.Zwierzęta, Trudność.Łatwy));
        listaSłów.add(new Słowo("kaczka","duck", SłowoKategoria.Zwierzęta, Trudność.Łatwy));
        listaSłów.add(new Słowo("orzeł","eagle", SłowoKategoria.Zwierzęta, Trudność.Łatwy));
        listaSłów.add(new Słowo("sokół","falcon", SłowoKategoria.Zwierzęta, Trudność.Łatwy));
        listaSłów.add(new Słowo("flaming","flamingo", SłowoKategoria.Zwierzęta, Trudność.Łatwy));

        listaSłów.add(new Słowo("gęś","goose", SłowoKategoria.Zwierzęta, Trudność.Trudny));
        listaSłów.add(new Słowo("mewa","gull", SłowoKategoria.Zwierzęta, Trudność.Trudny));
        listaSłów.add(new Słowo("struś","ostrich", SłowoKategoria.Zwierzęta, Trudność.Trudny));
        listaSłów.add(new Słowo("kawka","jackdaw", SłowoKategoria.Zwierzęta, Trudność.Trudny));
        listaSłów.add(new Słowo("sójka","jay", SłowoKategoria.Zwierzęta, Trudność.Trudny));
        listaSłów.add(new Słowo("pustułka","kestrel", SłowoKategoria.Zwierzęta, Trudność.Trudny));
        listaSłów.add(new Słowo("sowa","owl", SłowoKategoria.Zwierzęta, Trudność.Trudny));
        listaSłów.add(new Słowo("krzyżówka","mallard", SłowoKategoria.Zwierzęta, Trudność.Trudny));
        listaSłów.add(new Słowo("słowik","nightingale", SłowoKategoria.Zwierzęta, Trudność.Trudny));
        listaSłów.add(new Słowo("kowalik","nuthatch", SłowoKategoria.Zwierzęta, Trudność.Trudny));

        listaSłów.add(new Słowo("papuga","parrot", SłowoKategoria.Zwierzęta, Trudność.BardzoTrudny));
        listaSłów.add(new Słowo("paw","peacock", SłowoKategoria.Zwierzęta, Trudność.BardzoTrudny));
        listaSłów.add(new Słowo("pelikan","pelican", SłowoKategoria.Zwierzęta, Trudność.BardzoTrudny));
        listaSłów.add(new Słowo("pingwin","penguin", SłowoKategoria.Zwierzęta, Trudność.BardzoTrudny));
        listaSłów.add(new Słowo("bażant","pheasant", SłowoKategoria.Zwierzęta, Trudność.BardzoTrudny));
        listaSłów.add(new Słowo("pirania","piranha", SłowoKategoria.Zwierzęta, Trudność.BardzoTrudny));
        listaSłów.add(new Słowo("kruk","raven", SłowoKategoria.Zwierzęta, Trudność.BardzoTrudny));
        listaSłów.add(new Słowo("rudzik","robin", SłowoKategoria.Zwierzęta, Trudność.BardzoTrudny));
        listaSłów.add(new Słowo("kogut","rooster", SłowoKategoria.Zwierzęta, Trudność.BardzoTrudny));
        listaSłów.add(new Słowo("wróbel","sparrow", SłowoKategoria.Zwierzęta, Trudność.BardzoTrudny));

        listaSłów.add(new Słowo("bocian","stork", SłowoKategoria.Zwierzęta, Trudność.Ekspert));
        listaSłów.add(new Słowo("łabędź","swan", SłowoKategoria.Zwierzęta, Trudność.Ekspert));
        listaSłów.add(new Słowo("indyk","turkey", SłowoKategoria.Zwierzęta, Trudność.Ekspert));
        listaSłów.add(new Słowo("sęp","vulture", SłowoKategoria.Zwierzęta, Trudność.Ekspert));
        listaSłów.add(new Słowo("dzięcioł","woodpecker", SłowoKategoria.Zwierzęta, Trudność.Ekspert));
        listaSłów.add(new Słowo("strzyżyk","wren", SłowoKategoria.Zwierzęta, Trudność.Ekspert));
        listaSłów.add(new Słowo("jedwabnik","silkworm", SłowoKategoria.Zwierzęta, Trudność.Ekspert));
        listaSłów.add(new Słowo("dorsz","cod", SłowoKategoria.Zwierzęta, Trudność.Ekspert));
        listaSłów.add(new Słowo("krab","crab", SłowoKategoria.Zwierzęta, Trudność.Ekspert));
        listaSłów.add(new Słowo("węgorz","eel", SłowoKategoria.Zwierzęta, Trudność.Ekspert));
        //
        listaSłów.add(new Słowo("złota rybka","goldfish", SłowoKategoria.Kolowkwium, Trudność.BradzoŁatwy));
        listaSłów.add(new Słowo("plamiak","haddock", SłowoKategoria.Kolowkwium, Trudność.BradzoŁatwy));
        listaSłów.add(new Słowo("halibut","halibut", SłowoKategoria.Kolowkwium, Trudność.BradzoŁatwy));
        listaSłów.add(new Słowo("meduza","jellyfish", SłowoKategoria.Kolowkwium, Trudność.BradzoŁatwy));
        listaSłów.add(new Słowo("homar","lobster", SłowoKategoria.Kolowkwium, Trudność.BradzoŁatwy));
        listaSłów.add(new Słowo("okoń","perch", SłowoKategoria.Kolowkwium, Trudność.BradzoŁatwy));
        listaSłów.add(new Słowo("szczupak","pike", SłowoKategoria.Kolowkwium, Trudność.BradzoŁatwy));
        listaSłów.add(new Słowo("gładzica","plaice", SłowoKategoria.Kolowkwium, Trudność.BradzoŁatwy));
        listaSłów.add(new Słowo("promień","ray", SłowoKategoria.Kolowkwium, Trudność.BradzoŁatwy));
        listaSłów.add(new Słowo("łosoś","salmon", SłowoKategoria.Kolowkwium, Trudność.BradzoŁatwy));

        listaSłów.add(new Słowo("ryba piła","sawfish", SłowoKategoria.Kolowkwium, Trudność.Łatwy));
        listaSłów.add(new Słowo("przegrzebek","scallop", SłowoKategoria.Kolowkwium, Trudność.Łatwy));
        listaSłów.add(new Słowo("rekin","shark", SłowoKategoria.Kolowkwium, Trudność.Łatwy));
        listaSłów.add(new Słowo("muszla","shell", SłowoKategoria.Kolowkwium, Trudność.Łatwy));
        listaSłów.add(new Słowo("krewetka","shrimp", SłowoKategoria.Kolowkwium, Trudność.Łatwy));
        listaSłów.add(new Słowo("pstrąg","trout", SłowoKategoria.Kolowkwium, Trudność.Łatwy));
        listaSłów.add(new Słowo("owady","insects", SłowoKategoria.Kolowkwium, Trudność.Łatwy));
        listaSłów.add(new Słowo("mrówka","ant", SłowoKategoria.Kolowkwium, Trudność.Łatwy));
        listaSłów.add(new Słowo("mszyca","aphid", SłowoKategoria.Kolowkwium, Trudność.Łatwy));
        listaSłów.add(new Słowo("pszczoła","bee", SłowoKategoria.Kolowkwium, Trudność.Łatwy));

        listaSłów.add(new Słowo("chrząszcz","beetle", SłowoKategoria.Kolowkwium, Trudność.Trudny));
        listaSłów.add(new Słowo("trzmiel","bumblebee", SłowoKategoria.Kolowkwium, Trudność.Trudny));
        listaSłów.add(new Słowo("gąsienica","caterpillar", SłowoKategoria.Kolowkwium, Trudność.Trudny));
        listaSłów.add(new Słowo("karaluch","cockroach", SłowoKategoria.Kolowkwium, Trudność.Trudny));
        listaSłów.add(new Słowo("ważka","dragonfly", SłowoKategoria.Kolowkwium, Trudność.Trudny));
        listaSłów.add(new Słowo("pchła","flea", SłowoKategoria.Kolowkwium, Trudność.Trudny));
        listaSłów.add(new Słowo("giez","gadfly", SłowoKategoria.Kolowkwium, Trudność.Trudny));
        listaSłów.add(new Słowo("konik polny","grasshopper", SłowoKategoria.Kolowkwium, Trudność.Trudny));
        listaSłów.add(new Słowo("żniwiarz","harvestman", SłowoKategoria.Kolowkwium, Trudność.Trudny));
        listaSłów.add(new Słowo("biedronka","ladybug", SłowoKategoria.Kolowkwium, Trudność.Trudny));

        listaSłów.add(new Słowo("larwa","larva", SłowoKategoria.Kolowkwium, Trudność.BardzoTrudny));
        listaSłów.add(new Słowo("wesz","louse", SłowoKategoria.Kolowkwium, Trudność.BardzoTrudny));
        listaSłów.add(new Słowo("antylopa","antelope", SłowoKategoria.Kolowkwium, Trudność.BardzoTrudny));
        listaSłów.add(new Słowo("pancernik","armadillo", SłowoKategoria.Kolowkwium, Trudność.BardzoTrudny));
        listaSłów.add(new Słowo("stonoga","millipede", SłowoKategoria.Kolowkwium, Trudność.BardzoTrudny));
        listaSłów.add(new Słowo("ćma","moth", SłowoKategoria.Kolowkwium, Trudność.BardzoTrudny));
        listaSłów.add(new Słowo("nimfa","nymph", SłowoKategoria.Kolowkwium, Trudność.BardzoTrudny));
        listaSłów.add(new Słowo("osa","wasp", SłowoKategoria.Kolowkwium, Trudność.BardzoTrudny));
        listaSłów.add(new Słowo("ssaki","mammals", SłowoKategoria.Kolowkwium, Trudność.BardzoTrudny));
        listaSłów.add(new Słowo("mrówkojad","anteater", SłowoKategoria.Kolowkwium, Trudność.BardzoTrudny));

        listaSłów.add(new Słowo("borsuk","badger", SłowoKategoria.Kolowkwium, Trudność.Ekspert));
        listaSłów.add(new Słowo("nietoperz","bat", SłowoKategoria.Kolowkwium, Trudność.Ekspert));
        listaSłów.add(new Słowo("niedźwiedź","bear", SłowoKategoria.Kolowkwium, Trudność.Ekspert));
        listaSłów.add(new Słowo("bóbr","beaver", SłowoKategoria.Kolowkwium, Trudność.Ekspert));
        listaSłów.add(new Słowo("byczek","bullock", SłowoKategoria.Kolowkwium, Trudność.Ekspert));
        listaSłów.add(new Słowo("wielbłąd","camel", SłowoKategoria.Kolowkwium, Trudność.Ekspert));
        listaSłów.add(new Słowo("szympans","chimpanzee", SłowoKategoria.Kolowkwium, Trudność.Ekspert));
        listaSłów.add(new Słowo("jamnik","dachshund", SłowoKategoria.Kolowkwium, Trudność.Ekspert));
        listaSłów.add(new Słowo("jeleń","deer", SłowoKategoria.Kolowkwium, Trudność.Ekspert));
        listaSłów.add(new Słowo("delfin","dolphin", SłowoKategoria.Kolowkwium, Trudność.Ekspert));
        //
        listaSłów.add(new Słowo("niebieski","blue", SłowoKategoria.Kolory, Trudność.BradzoŁatwy));
        listaSłów.add(new Słowo("czerwony","red", SłowoKategoria.Kolory, Trudność.BradzoŁatwy));
        listaSłów.add(new Słowo("biały","white", SłowoKategoria.Kolory, Trudność.BradzoŁatwy));
        listaSłów.add(new Słowo("żółty","yellow", SłowoKategoria.Kolory, Trudność.BradzoŁatwy));
        listaSłów.add(new Słowo("złoty","gold", SłowoKategoria.Kolory, Trudność.BradzoŁatwy));
        listaSłów.add(new Słowo("zielony","green", SłowoKategoria.Kolory, Trudność.BradzoŁatwy));
        listaSłów.add(new Słowo("szary","grey", SłowoKategoria.Kolory, Trudność.BradzoŁatwy));
        listaSłów.add(new Słowo("brązowy","brown", SłowoKategoria.Kolory, Trudność.BradzoŁatwy));
        listaSłów.add(new Słowo("różowy","pink", SłowoKategoria.Kolory, Trudność.BradzoŁatwy));
        listaSłów.add(new Słowo("srebrny","silver", SłowoKategoria.Kolory, Trudność.BradzoŁatwy));

        listaSłów.add(new Słowo("Zero absolutne","Absolute Zero", SłowoKategoria.Kolory, Trudność.Łatwy));
        listaSłów.add(new Słowo("Kwaśny zielony","Acid green", SłowoKategoria.Kolory, Trudność.Łatwy));
        listaSłów.add(new Słowo("Aero","Aero", SłowoKategoria.Kolory, Trudność.Łatwy));
        listaSłów.add(new Słowo("Aero niebieski","Aero blue", SłowoKategoria.Kolory, Trudność.Łatwy));
        listaSłów.add(new Słowo("Fiołek afrykański","African violet", SłowoKategoria.Kolory, Trudność.Łatwy));
        listaSłów.add(new Słowo("Niebieska przewaga powietrza","Air superiority blue", SłowoKategoria.Kolory, Trudność.Łatwy));
        listaSłów.add(new Słowo("Alabaster","Alabaster", SłowoKategoria.Kolory, Trudność.Łatwy));
        listaSłów.add(new Słowo("Stop pomarańczowy","Alloy orange", SłowoKategoria.Kolory, Trudność.Łatwy));
        listaSłów.add(new Słowo("Migdałowy","Almond", SłowoKategoria.Kolory, Trudność.Łatwy));
        listaSłów.add(new Słowo("Amarant","Amaranth", SłowoKategoria.Kolory, Trudność.Łatwy));

        listaSłów.add(new Słowo("Amarantowy głęboki fiolet","Amaranth deep purple", SłowoKategoria.Kolory, Trudność.Trudny));
        listaSłów.add(new Słowo("Amarantowy róż","Amaranth pink", SłowoKategoria.Kolory, Trudność.Trudny));
        listaSłów.add(new Słowo("Amarantowy fiolet","Amaranth purple", SłowoKategoria.Kolory, Trudność.Trudny));
        listaSłów.add(new Słowo("Amarantowy czerwony","Amaranth red", SłowoKategoria.Kolory, Trudność.Trudny));
        listaSłów.add(new Słowo("Amazonka","Amazon", SłowoKategoria.Kolory, Trudność.Trudny));
        listaSłów.add(new Słowo("Bursztyn","Amber", SłowoKategoria.Kolory, Trudność.Trudny));
        listaSłów.add(new Słowo("Ametyst","Amethyst", SłowoKategoria.Kolory, Trudność.Trudny));
        listaSłów.add(new Słowo("Antyczny mosiądz","Antique brass", SłowoKategoria.Kolory, Trudność.Trudny));
        listaSłów.add(new Słowo("Antyczny brąz","Antique bronze", SłowoKategoria.Kolory, Trudność.Trudny));
        listaSłów.add(new Słowo("Antyczna fuksja","Antique fuchsia", SłowoKategoria.Kolory, Trudność.Trudny));

        listaSłów.add(new Słowo("Antyczny rubin","Antique ruby", SłowoKategoria.Kolory, Trudność.BardzoTrudny));
        listaSłów.add(new Słowo("Antyczna biel","Antique white", SłowoKategoria.Kolory, Trudność.BardzoTrudny));
        listaSłów.add(new Słowo("Zielone jabłko","Apple green", SłowoKategoria.Kolory, Trudność.BardzoTrudny));
        listaSłów.add(new Słowo("Morela","Apricot", SłowoKategoria.Kolory, Trudność.BardzoTrudny));
        listaSłów.add(new Słowo("Morski","Aqua", SłowoKategoria.Kolory, Trudność.BardzoTrudny));
        listaSłów.add(new Słowo("Akwamaryn","Aquamarine", SłowoKategoria.Kolory, Trudność.BardzoTrudny));
        listaSłów.add(new Słowo("Wapno arktyczne","Arctic lime", SłowoKategoria.Kolory, Trudność.BardzoTrudny));
        listaSłów.add(new Słowo("Argentyński niebieski","Argentinian blue", SłowoKategoria.Kolory, Trudność.BardzoTrudny));
        listaSłów.add(new Słowo("Zieleń wojskowa","Army green", SłowoKategoria.Kolory, Trudność.BardzoTrudny));
        listaSłów.add(new Słowo("Arylide żółty","Arylide yellow", SłowoKategoria.Kolory, Trudność.BardzoTrudny));

        listaSłów.add(new Słowo("Popielaty","Ash grey", SłowoKategoria.Kolory, Trudność.Ekspert));
        listaSłów.add(new Słowo("Szparagowy","Asparagus", SłowoKategoria.Kolory, Trudność.Ekspert));
        listaSłów.add(new Słowo("Atomowa mandarynka","Atomic tangerine", SłowoKategoria.Kolory, Trudność.Ekspert));
        listaSłów.add(new Słowo("Kasztanowy","Auburn", SłowoKategoria.Kolory, Trudność.Ekspert));
        listaSłów.add(new Słowo("Aureolina","Aureolin", SłowoKategoria.Kolory, Trudność.Ekspert));
        listaSłów.add(new Słowo("Awokado","Avocado", SłowoKategoria.Kolory, Trudność.Ekspert));
        listaSłów.add(new Słowo("Lazur","Azure", SłowoKategoria.Kolory, Trudność.Ekspert));
        listaSłów.add(new Słowo("Dziecięcy róż","Baby pink", SłowoKategoria.Kolory, Trudność.Ekspert));
        listaSłów.add(new Słowo("Bananowy","Banana yellow", SłowoKategoria.Kolory, Trudność.Ekspert));
        listaSłów.add(new Słowo("Barbie róż","Barbie pink", SłowoKategoria.Kolory, Trudność.Ekspert));
    }
}
