package harpoonDiver.core;

import harpoonDiver.common.ConstantMessages;
import harpoonDiver.common.ExceptionMessages;
import harpoonDiver.models.diver.DeepWaterDiver;
import harpoonDiver.models.diver.Diver;
import harpoonDiver.models.diver.OpenWaterDiver;
import harpoonDiver.models.diver.WreckDiver;
import harpoonDiver.models.diving.Diving;
import harpoonDiver.models.diving.DivingImpl;
import harpoonDiver.models.divingSite.DivingSite;
import harpoonDiver.models.divingSite.DivingSiteImpl;
import harpoonDiver.repositories.DiverRepository;
import harpoonDiver.repositories.DivingSiteRepository;
import harpoonDiver.repositories.Repository;

import java.util.List;
import java.util.stream.Collectors;

public class ControllerImpl implements Controller {
    private Repository<Diver> diverRepository;
    private Repository<DivingSite> divingSiteRepository;
    private int siteCount;

    public ControllerImpl () {
        this.diverRepository = new DiverRepository ( );
        this.divingSiteRepository = new DivingSiteRepository ( );
    }

    @Override
    public String addDiver ( String kind, String diverName ) {
        Diver diver;
        switch (kind) {
            case "WreckDiver":
                diver = new WreckDiver ( diverName );
                break;
            case "OpenWaterDiver":
                diver = new OpenWaterDiver ( diverName );
                break;
            case "DeepWaterDiver":
                diver = new DeepWaterDiver ( diverName );
                break;
            default:
                throw new IllegalArgumentException ( ExceptionMessages.DIVER_INVALID_KIND );
        }
        this.diverRepository.add ( diver );
        return String.format ( ConstantMessages.DIVER_ADDED, kind, diverName );
    }

    @Override
    public String addDivingSite ( String siteName, String... seaCreatures ) {
        DivingSite site = new DivingSiteImpl ( siteName );
        for ( String creature : seaCreatures ) {
            site.getSeaCreatures ( ).add ( creature );
        }
        this.divingSiteRepository.add ( site );
        return String.format ( ConstantMessages.DIVING_SITE_ADDED, siteName );
    }

    @Override
    public String removeDiver ( String diverName ) {
        Diver diver = this.diverRepository.byName ( diverName );
        if ( diver == null || !this.diverRepository.remove ( diver ) ) {
            throw new IllegalArgumentException (
                    String.format (
                            ExceptionMessages.DIVER_DOES_NOT_EXIST,
                            diverName ) );
        }

        return String.format ( ConstantMessages.DIVER_REMOVE, diverName );
    }

    @Override
    public String startDiving ( String siteName ) {

        List<Diver> capableDivers = this.diverRepository.getCollection ( ).stream ( )
                .filter ( d -> d.getOxygen ( ) > 30 )
                .collect ( Collectors.toList ( ) );

        DivingSite site = this.divingSiteRepository.byName ( siteName );

        if ( capableDivers.isEmpty ()) {
            throw new IllegalArgumentException ( ExceptionMessages.SITE_DIVERS_DOES_NOT_EXISTS );
        }
        Diving diving = new DivingImpl ( );

        diving.searching ( site, capableDivers );

        long excludedDivers = capableDivers
                .stream ( )
                .filter ( d -> d.getOxygen ( ) <= 0 )
                .count ( );

        this.siteCount++;

        return String.format ( ConstantMessages.SITE_DIVING, siteName, excludedDivers );
    }

    @Override
    public String getStatistics () {
        StringBuilder reportBuilder = new StringBuilder (
                String.format ( ConstantMessages.
                                FINAL_DIVING_SITES,
                        this.siteCount ) );

        reportBuilder.append ( System.lineSeparator ( ) );

        reportBuilder.append ( ConstantMessages.FINAL_DIVERS_STATISTICS );
        reportBuilder.append ( System.lineSeparator ( ) );

        for ( Diver diver : diverRepository.getCollection ( ) ) {
            reportBuilder.append ( String.format ( ConstantMessages.FINAL_DIVER_NAME, diver.getName ( ) ) );
            reportBuilder.append ( System.lineSeparator ( ) );

            reportBuilder.append ( String.format ( ConstantMessages.FINAL_DIVER_OXYGEN, diver.getOxygen ( ) ) );
            reportBuilder.append ( System.lineSeparator ( ) );

            String catcH = diver.getSeaCatch ( ).getSeaCreatures ( ).isEmpty ( ) ?
                    "None" :
                    diver.getSeaCatch ( ).getSeaCreatures ( ).stream( ).collect ( Collectors.joining ( ConstantMessages.FINAL_DIVER_CATCH_DELIMITER ));

            reportBuilder.append ( String.format ( ConstantMessages.FINAL_DIVER_CATCH, catcH ) );
            reportBuilder.append ( System.lineSeparator ( ) );
        }

        return reportBuilder.toString ( );
    }
}
