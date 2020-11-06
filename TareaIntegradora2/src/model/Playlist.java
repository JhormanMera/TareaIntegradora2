package model;

public abstract class Playlist {
		private final static int AMOUNT_GENRES=7;
		private final static int AMOUNT_SONGS=30;
		private final MusicalGender[] genres =MusicalGender.values();
        private String name;
        private String duration;
		private int durationTotal;
        private String[] genreSet;
		private Song[] songs;
    
        public Playlist(String name){
        this.genreSet=new String[AMOUNT_GENRES];
		this.songs= new Song[AMOUNT_SONGS];
		genreSet[0]=genres[0].name();
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
		public int updateDurationTotal(int songDuration){
			this.durationTotal+=songDuration;
		}
		public String updateGenre(){
			String updated="El genero de la Playlist no ha sido cambiado";
			boolean found=false;
			for(int i=0;i<AMOUNT_SONGS && !found; i++){
				if(songs[i] != null && genreSet[i] != null){
					found=songs[i].equalsIgnoreCase(genreSet[i]);
					if(found==false){
						genreSet[i]=songs[i].getGenre();
						updated="El genero de la Playlist ha cambiado"
					}
				}
			}
			return updated;
		}
        public void setDuration(){
			int hour=(int)durationTotal/3600;
			int minute=(int)(durationTotal-(3600*hour))/60;
			int seconds=(int)durationTotal-(hour*3600)+(minute*60));
			if(minute<10){
				this.duration="0"+hour+":"+"0"+minute+":"+seconds;
			}
			else{
				this.duration="0"+hour+":"+minute+":"+seconds;
			}
        }
		public String showGenre(){
		String msg="";
		for(int i=0;i<AMOUNT_GENRES;i++){
			if(genreSet[i] != null){
				msg += genreSet[i]+", ";
			}
		}
		return msg;
		}
		@Override
		public abstract String showContent();
		}						
    }
