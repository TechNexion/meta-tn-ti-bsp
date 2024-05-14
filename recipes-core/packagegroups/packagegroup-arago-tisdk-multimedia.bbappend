# Do not add 'libcamera' to image.
# TechNexion TEVS camera currently lacks support for libcamera
MULTIMEDIA:remove:rovy-4vm = " libcamera libcamera-gst"