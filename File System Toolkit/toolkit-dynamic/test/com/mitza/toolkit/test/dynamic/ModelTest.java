package com.mitza.toolkit.test.dynamic;

import com.mitza.toolkit.model.ModelFactory;
import com.mitza.util.TcmUri;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Mihai Cadariu
 * @since 18.12.2016
 */
public class ModelTest {

    private final Logger log = LoggerFactory.getLogger(ModelTest.class);
    private final ModelFactory modelFactory = ModelFactory.INSTANCE;
    private final String[] tcmuris = new String[]{
            "tcm:6-1118", "tcm:6-1151", "tcm:6-1153", "tcm:6-1154", "tcm:6-1155", "tcm:6-1156", "tcm:6-1157", "tcm:6-1158",
            "tcm:6-1159", "tcm:6-1160", "tcm:6-1161", "tcm:6-1162", "tcm:6-1163", "tcm:6-1164", "tcm:6-1165", "tcm:6-1166",
            "tcm:6-1167", "tcm:6-1168", "tcm:6-1169", "tcm:6-1170", "tcm:6-1171", "tcm:6-1172", "tcm:6-1173", "tcm:6-1174",
            "tcm:6-1175", "tcm:6-1176", "tcm:6-1177", "tcm:6-1178", "tcm:6-1179", "tcm:6-1180", "tcm:6-1181", "tcm:6-1182",
            "tcm:6-1187", "tcm:6-1188", "tcm:6-1189", "tcm:6-1190", "tcm:6-1191", "tcm:6-1192", "tcm:6-1193", "tcm:6-1194",
            "tcm:6-1195", "tcm:6-1196", "tcm:6-1197", "tcm:6-1198", "tcm:6-1199", "tcm:6-1200", "tcm:6-1201", "tcm:6-1202",
            "tcm:6-1203", "tcm:6-1204", "tcm:6-1205", "tcm:6-1206", "tcm:6-1207", "tcm:6-1208", "tcm:6-1209", "tcm:6-1210",
            "tcm:6-1211", "tcm:6-1212", "tcm:6-1213", "tcm:6-1214", "tcm:6-1215", "tcm:6-1216", "tcm:6-1217", "tcm:6-1218",
            "tcm:6-1219", "tcm:6-52", "tcm:6-82"};

    public ModelTest() {
//        long duration = System.currentTimeMillis();
//        log.debug("Start ModelTest");

        warmupTest();

//        duration = System.currentTimeMillis() - duration;
//        log.debug("<<< ModelTest duration {} millis", duration);
    }

    private void warmupTest() {
        modelFactory.getModel(new TcmUri(6, 1225, 64));
    }

    public void runTest() {
        for (String tcmUri : tcmuris) {
            modelFactory.getModel(new TcmUri(tcmUri));
//            ComponentMeta model = modelFactory.getModel(new TcmUri(tcmUri));
//            log.info("Model {}", model);
        }
    }
}
