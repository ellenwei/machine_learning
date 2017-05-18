from nltk.corpus import brown
import numpy as np
from PIL import Image
from sklearn.cluster import KMeans
from keras import backend as K


print 'Here are a bunch of words'
print brown.words()