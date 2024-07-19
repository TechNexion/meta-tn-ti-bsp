DISTRO_FEATURES_axon-am62ax += "wayland"

IMAGE_INSTALL_append = "\
    packagegroup-tn-wlan \
    stressapptest \
    ramsmp \
    fbida \
    spidev-test \
    minicom \
    ofono \
    ofono-tests \
    wireless-tools \
    gst-shark \
"
