FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI:append:rovy-4vm = "\
   file://0001-scripts-setup_cameras-Add-support-for-TEVI-and-TEVS-.patch\
"

# The main recipe set ${S} so that it runs cmake on the
# apps_cpp directory. This causes the do_patch function to fail
# when applying patches to other directories.  So we change ${S}
# prior to do_patch() to the main source directory, and then
# will change it back after patching is completed.

# Storing 'ts' is possible because of the way that prepend and
# append functions work.  The contents of these functions are
# placed within the do_patch() function, so the 'ts' variable is
# local to both :append() and :prepend() functions.

do_patch:prepend() {

    # Store original value of S
    ts =  d.getVar('S')

    # Set S to the main source directory
    d.setVar('S',"${WORKDIR}/git")
}

do_patch:append() {

    # Change S back to setting in main package recipe.
    d.setVar('S',ts)
    
}

PR:append = "_tn_1"

