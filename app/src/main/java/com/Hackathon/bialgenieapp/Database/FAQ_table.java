package com.Hackathon.bialgenieapp.Database;

import com.azure.data.tables.TableClient;
import com.azure.data.tables.TableServiceClient;
import com.azure.data.tables.TableServiceClientBuilder;

public class FAQ_table {

    final String tableName = "FAQ";
    // Define the connection-string with your values.
    public final String connectionString =
            "DefaultEndpointsProtocol=https;AccountName=bialtable;AccountKey=wRCVF2troxwyrE9pieQU0tjN84QSOwnq0ybCZBg+b76/EIUD3xFmM2p19Dn8hiIyKWGs1gPAm5cyKhHxh2y7oA==;EndpointSuffix=core.windows.net";
    public void create_Table()
    {
        try
        {
            // Create a TableServiceClient with a connection string.
            TableServiceClient tableServiceClient = new TableServiceClientBuilder()
                    .connectionString(connectionString)
                    .buildClient();

            // Create the table if it not exists.
            TableClient tableClient = tableServiceClient.createTableIfNotExists(tableName);

        }
        catch (Exception e)
        {
            // Output the stack trace.
            e.printStackTrace();
        }
    }


}
