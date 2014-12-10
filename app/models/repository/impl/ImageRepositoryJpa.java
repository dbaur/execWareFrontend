package models.repository.impl;

import models.Image;
import models.repository.api.ImageRepository;
import models.repository.impl.generic.ModelRepositoryJpa;
import models.repository.impl.generic.NamedModelRepositoryJpa;

/**
 * Created by daniel seybold on 10.12.2014.
 */
public class ImageRepositoryJpa extends NamedModelRepositoryJpa<Image> implements ImageRepository {
}
