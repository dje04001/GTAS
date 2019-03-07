/*
 * All GTAS code is Copyright 2016, The Department of Homeland Security (DHS), U.S. Customs and Border Protection (CBP).
 * 
 * Please see LICENSE.txt for details.
 */
package gov.gtas.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "bag")
public class Bag extends BaseEntity {
    private static final long serialVersionUID = 1L;

	public Bag() {
    }

    @Column(name = "bag_identification", nullable = false)
    private String bagId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(nullable = false)
	private Passenger passenger;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "flight_id",referencedColumnName = "id", nullable = false)
	private Flight flight;
	
    @Column(name = "data_source")
    private String data_source;
    
    private String destination;

    @Column(name = "destination_airport")
	private String destinationAirport;
    
    @Column(name = "airline")
	private String airline;
    
    @Column(name = "headpool")
	private boolean headPool=false;

    
	public boolean isHeadPool() {
		return headPool;
	}

	public void setHeadPool(boolean headPool) {
		this.headPool = headPool;
	}

	public String getDestinationAirport() {
		return destinationAirport;
	}

	public void setDestinationAirport(String destinationAirport) {
		this.destinationAirport = destinationAirport;
	}

	public String getAirline() {
		return airline;
	}

	public void setAirline(String airline) {
		this.airline = airline;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getData_source() {
		return data_source;
	}

	public void setData_source(String data_source) {
		this.data_source = data_source;
	}

	public Passenger getPassenger() {
		return passenger;
	}

	public void setPassenger(Passenger passenger) {
		this.passenger = passenger;
	}

	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

	public String getBagId() {
        return bagId;
    }

    public void setBagId(String bagId) {
        this.bagId = bagId;
    }
    @Override
	public String toString() {

        return "\nbagid " +
                bagId +
                "\npass id " +
                passenger.getId() +
                "\nflight id " +
                flight.getId() +
                "\ndata source " +
                data_source +
                "\nDestination " +
                destination +
                "\nDestination airport " +
                destinationAirport +
                "\nAirline " +
                airline;
	}


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Bag bag = (Bag) o;
		return getBagId().equals(bag.getBagId()) &&
				getData_source().equals(bag.getData_source());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getBagId(), getData_source());
	}



}
