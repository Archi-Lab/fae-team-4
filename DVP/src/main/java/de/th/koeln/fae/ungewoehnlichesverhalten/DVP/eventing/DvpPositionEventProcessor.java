package de.th.koeln.fae.ungewoehnlichesverhalten.DVP.eventing;

import de.th.koeln.fae.ungewoehnlichesverhalten.DVP.models.Aufenthaltsort;
import org.apache.kafka.clients.consumer.ConsumerRecord;

public class DvpPositionEventProcessor {

    protected void processEvent(final DvpPositionEvent positionEvent) {
        switch (positionEvent.getType()) {
            case "tracker-tracked":
              // repository.save(toAufenthaltsort(positionEvent));
                System.out.println("save");
                break;
            default:
                /* LOG.warn("Unexpected type: '{}' of message with key '{}'", productEvent.getType(),
                        productEvent.getKey()); */
        }
    }

    private Aufenthaltsort toAufenthaltsort(final DvpPositionEvent positionEvent) {
        final Aufenthaltsort aufenthaltsort = new Aufenthaltsort();
        /*
        Beispiel:

        final Product product = new Product();
        product.setId(productEvent.getPayload().getId());
        product.setDescription(productEvent.getPayload().getDescription());
        product.setImage(productEvent.getPayload().getImage());
        product.setPrice(productEvent.getPayload().getPrice());
        product.setProductNumber(productEvent.getPayload().getProductNumber());
        product.setVendor(productEvent.getPayload().getVendor());
        product.setName(productEvent.getPayload().getName());
        product.setVersion(productEvent.getVersion());
        return product;
        */

        return aufenthaltsort;
    }
}
