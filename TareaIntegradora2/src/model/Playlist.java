package model;

public abstract class Playlist {
        private String name;
        private String duration;
        private String genreSet;
    
        public Playlist(String name){
        this.genreSet="";
        this.duration="00:00";
        this.name= name;
        }
        public String getName(){
            return name;
        }
        public void setName(String name){
            this.name= name;
        }
        public String getDuration(){
            return duration;
        }
        public void setDuration(String duration){
            this.duration= duration;
        }
        public String getGenreSet(){
            return genreSet;
        }
        public void setGenreSet(String genreSet){
            this.genreSet= genreSet;
        }
		@Override
		public String showContent(){
			String msg=" **************  Playlist **************/n"+
						"**  Title: "+name+"/n"+
						"**  Duration: "+ duration+"/n"+
						"**  Genre: "+genreSet+"/n";
			return msg;
		}						
    }
