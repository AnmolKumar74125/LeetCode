class Solution {
public:
    vector<string> validateCoupons(vector<string>& code, vector<string>& businessLine, vector<bool>& isActive) {
        
        vector<string> elec;
        vector<string> groc;
        vector<string> phar;
        vector<string> rest;
        vector<string> ans;
        for(int i = 0; i < businessLine.size(); i++)
        {
            /*
            if((strcmp(businessLine[i], "electronics") && strcmp(businessLine[i], "grocery") &&strcmp(businessLine[i], "pharmacy") && strcmp(businessLine[i], "restaurant"))
            {
                isActive[i] = false;
            }
            */
            for(int j = 0; j < code[i].length();j++)
            {
                if(!((code[i][j] >= 65 && code[i][j] <= 91) || (code[i][j] >= 97 && code[i][j] <= 122) || (code[i][j] >= 48 && code[i][j] <= 57) || (code[i][j] == 95)))
                {
                    isActive[i] = false;
                    break;
                }
            }
            if(code[i].length() == 0)
            {
                isActive[i] = false;
            }
            if(isActive[i])
            {
                if(!(strcmp(businessLine[i].c_str(), "electronics")))
                {
                    cout<<"A"<<endl;
                    elec.push_back(code[i]);
                }
                else if(!(strcmp(businessLine[i].c_str(), "grocery")))
                {
                    cout<<"B"<<endl;
                    groc.push_back(code[i]);
                }
                else if(!(strcmp(businessLine[i].c_str(), "pharmacy")))
                {
                    cout<<"C"<<endl;
                    phar.push_back(code[i]);
                }
                else if(!(strcmp(businessLine[i].c_str(), "restaurant")))
                {
                    cout<<"D"<<endl;
                    rest.push_back(code[i]);
                }
            }
        }
        sort(elec.begin(),elec.end());
        sort(groc.begin(),groc.end());
        sort(phar.begin(),phar.end());
        sort(rest.begin(),rest.end());

        ans = elec;
        ans.insert(ans.end(), groc.begin(),groc.end());
        ans.insert(ans.end(), phar.begin(),phar.end());
        ans.insert(ans.end(), rest.begin(),rest.end());
        
        return ans;
    }
};