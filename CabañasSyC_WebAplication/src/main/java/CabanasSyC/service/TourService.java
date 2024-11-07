package CabanasSyC.service;

import java.util.List;
import CabanasSyC.domain.Tour;

public interface TourService {
    public List<Tour> getAllTours();

    public Tour getTourById(Long id);

    public void saveOrUpdate(Tour tour);
    
    public void deleteTour(Long id);
}