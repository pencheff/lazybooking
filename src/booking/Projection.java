package booking;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Projection")
@XmlRootElement(name = "projection")
public class Projection implements Serializable {
	private int cinemaId;
	private int movieId;
	private int projectionId;
	private int seats;
	private int seatsAvailable;
	
	public int getCinemaId() {
		return cinemaId;
	}
	
	public void setCinemaId(int cinemaId) {
		this.cinemaId = cinemaId;
	}
	
	public int getMovieId() {
		return movieId;
	}
	
	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}
	
	public int getProjectionId() {
		return projectionId;
	}
	
	public void setProjectionId(int projectionId) {
		this.projectionId = projectionId;
	}
	
	public int getSeats() {
		return seats;
	}
	
	public void setSeats(int seats) {
		this.seats = seats;
	}
	
	public int getSeatsAvailable() {
		return seatsAvailable;
	}

	public void setSeatsAvailable(int seatsAvailable) {
		this.seatsAvailable = seatsAvailable;
	}
}
