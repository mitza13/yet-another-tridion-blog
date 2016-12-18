package com.mitza.toolkit.dd4t.provider;

import com.mitza.toolkit.configuration.ToolkitConfiguration;
import org.dd4t.core.exceptions.ItemNotFoundException;
import org.dd4t.core.exceptions.SerializationException;
import org.dd4t.core.util.TCMURI;
import org.dd4t.providers.PageProvider;
import org.dd4t.providers.ProviderResultItem;
import org.dd4t.providers.StringResultItemImpl;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.ParseException;
import java.util.Date;

/**
 * @author Mihai Cadariu
 * @since 08.05.2016
 */
public class ToolkitPageProvider implements PageProvider {

    private final String contentRoot;

    public ToolkitPageProvider() {
        ToolkitConfiguration configuration = ToolkitConfiguration.INSTANCE;
        contentRoot = configuration.getContentRoot();
    }

    @Override
    public ProviderResultItem<String> getPageById(int id, int publication) throws IOException, ItemNotFoundException, SerializationException {
        return null;
    }

    @Override
    public ProviderResultItem<String> getPageByURL(String url, int publication) throws ItemNotFoundException, SerializationException {
        try {
            File pageFile = new File(contentRoot, url);

            if (pageFile.exists()) {
                ProviderResultItem<String> result = new StringResultItemImpl();
                String content = new String(Files.readAllBytes(pageFile.toPath()));
                result.setContentSource(content);

                //TODO
                Date date = new Date(pageFile.lastModified());
                result.setLastPublishDate(date);
                result.setRevisionDate(date);

                return result;
            } else {
                throw new ItemNotFoundException("Page file does not exist " + pageFile);
            }
        } catch (IOException e) {
            throw new SerializationException("Error reading page file content", e);
        }
    }

    @Override
    public String getPageContentById(int id, int publication) throws IOException, ItemNotFoundException, SerializationException {
        return null;
    }

    /**
     * Retrieves a Page by its Publication and URL. It returns JSON representing a Page model object.
     *
     * @param url         String representing the path part of the page URL
     * @param publication int representing the context Publication id to read the Page from
     * @return String representing the JSON encoded Page model object
     * @throws ItemNotFoundException  if said page cannot be found
     * @throws SerializationException if response from service does not represent a serialized Page
     */
    @Override
    public String getPageContentByURL(String url, int publication) throws ItemNotFoundException, SerializationException {
        return null;
    }

    /**
     * Retrieves a Page by its TCMURI. It returns JSON representing a Page model object.
     *
     * @param tcmUri String representing the Tridion Page URI
     * @return String representing the JSON encoded Page model object
     * @throws ItemNotFoundException  if said page cannot be found
     * @throws ParseException         if given parameter does not represent a TCMURI
     * @throws SerializationException if response from service does not represent a serialized Page
     */
    @Override
    public String getPageContentById(String tcmUri) throws ItemNotFoundException, ParseException, SerializationException {
        return null;
    }

    /**
     * Retrieves a list of published page URLs as one String.
     *
     * @param publication the Publication Id
     * @return A String containing all publication URLs
     * @throws ItemNotFoundException
     * @throws SerializationException
     */
    @Override
    public String getPageListByPublicationId(int publication) throws ItemNotFoundException, SerializationException {
        return null;
    }

    /**
     * Checks whether a page exists (published from Tridion) by querying its URL
     *
     * @param url           String representing the path part of the page URL
     * @param publicationId int representing the context Publication id to read the Page from
     * @return Boolean True if the page is published and exists
     * @throws ItemNotFoundException  if said page cannot be found
     * @throws SerializationException if there was an error communicating with the service
     */
    @Override
    public boolean checkPageExists(String url, int publicationId) throws ItemNotFoundException, SerializationException {
        return false;
    }

    @Override
    public TCMURI getPageIdForUrl(String url, int publicationId) throws ItemNotFoundException, SerializationException {
        return null;
    }

    @Override
    public org.joda.time.DateTime getLastPublishDate(String url, int publication) throws ItemNotFoundException {
        return null;
    }
}
