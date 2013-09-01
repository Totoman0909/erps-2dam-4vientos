/**
 * 
 */
package info.pello.playlist;


/**
 * Represents Playlist entity
 * @author Pello Xabier Altadill Izura
 * @greet to teachers who are users too
 */
public class Playlist {
	private Integer id;
	private String artist;
	private String song;
	private String url;
	
	/**
	 * default constructor
	 */
	public Playlist () {}
	
	/**
	 * @param id
	 * @param artist
	 * @param song
	 * @param url
	 */
	public Playlist(Integer id, String artist, String song, String url) {
		this.id = id;
		this.artist = artist;
		this.song = song;
		this.url = url;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Playlist [id=" + id + ", artist=" + artist + ", song=" + song
				+ ", url=" + url + "]";
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	
	/**
	 * @return the artist
	 */
	public String getArtist() {
		return artist;
	}
	
	/**
	 * @param artist the artist to set
	 */
	public void setArtist(String artist) {
		this.artist = artist;
	}
	
	/**
	 * @return the song
	 */
	public String getSong() {
		return song;
	}
	
	/**
	 * @param song the song to set
	 */
	public void setSong(String song) {
		this.song = song;
	}
	
	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}
	
	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	
	
}
